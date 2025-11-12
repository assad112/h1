package com.example.h1.activities;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.h1.R;
import com.example.h1.models.Booking;
import com.example.h1.models.Nursery;
import com.example.h1.utils.BookingManager;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class BookingActivity extends AppCompatActivity {
    
    private Nursery nursery;
    private EditText etChildName, etChildAge, etParentName, etParentPhone, etParentEmail, etNotes;
    private TextView tvStartDate, tvNurseryName, tvPrice;
    private RadioGroup rgPackageType;
    private Button btnSelectDate, btnSubmitBooking;
    private ImageButton btnBack;
    
    private Calendar selectedDate;
    private String selectedPackageType = "FULL_TIME";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        
        // Get nursery from intent
        nursery = (Nursery) getIntent().getSerializableExtra("nursery");
        
        if (nursery == null) {
            Toast.makeText(this, "Error loading nursery", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }
        
        selectedDate = Calendar.getInstance();
        
        initViews();
        displayNurseryInfo();
        setupButtons();
        setupRadioGroup();
    }
    
    private void initViews() {
        btnBack = findViewById(R.id.btnBack);
        tvNurseryName = findViewById(R.id.tvNurseryName);
        tvPrice = findViewById(R.id.tvPrice);
        etChildName = findViewById(R.id.etChildName);
        etChildAge = findViewById(R.id.etChildAge);
        etParentName = findViewById(R.id.etParentName);
        etParentPhone = findViewById(R.id.etParentPhone);
        etParentEmail = findViewById(R.id.etParentEmail);
        tvStartDate = findViewById(R.id.tvStartDate);
        btnSelectDate = findViewById(R.id.btnSelectDate);
        rgPackageType = findViewById(R.id.rgPackageType);
        etNotes = findViewById(R.id.etNotes);
        btnSubmitBooking = findViewById(R.id.btnSubmitBooking);
    }
    
    private void displayNurseryInfo() {
        tvNurseryName.setText(nursery.getName());
        tvPrice.setText(nursery.getPriceFormatted());
    }
    
    private void setupButtons() {
        btnBack.setOnClickListener(v -> finish());
        
        btnSelectDate.setOnClickListener(v -> showDatePicker());
        
        btnSubmitBooking.setOnClickListener(v -> submitBooking());
    }
    
    private void setupRadioGroup() {
        rgPackageType.setOnCheckedChangeListener((group, checkedId) -> {
            RadioButton radioButton = findViewById(checkedId);
            if (radioButton.getId() == R.id.rbFullTime) {
                selectedPackageType = "FULL_TIME";
            } else if (radioButton.getId() == R.id.rbPartTime) {
                selectedPackageType = "PART_TIME";
            } else if (radioButton.getId() == R.id.rbHourly) {
                selectedPackageType = "HOURLY";
            }
        });
    }
    
    private void showDatePicker() {
        Calendar minDate = Calendar.getInstance();
        minDate.add(Calendar.DAY_OF_MONTH, 1); // Start from tomorrow
        
        DatePickerDialog datePickerDialog = new DatePickerDialog(
            this,
            (view, year, month, dayOfMonth) -> {
                selectedDate.set(year, month, dayOfMonth);
                SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy", Locale.getDefault());
                tvStartDate.setText(sdf.format(selectedDate.getTime()));
            },
            selectedDate.get(Calendar.YEAR),
            selectedDate.get(Calendar.MONTH),
            selectedDate.get(Calendar.DAY_OF_MONTH)
        );
        
        datePickerDialog.getDatePicker().setMinDate(minDate.getTimeInMillis());
        datePickerDialog.show();
    }
    
    private void submitBooking() {
        // Validate inputs
        String childName = etChildName.getText().toString().trim();
        String childAgeStr = etChildAge.getText().toString().trim();
        String parentName = etParentName.getText().toString().trim();
        String parentPhone = etParentPhone.getText().toString().trim();
        String parentEmail = etParentEmail.getText().toString().trim();
        String notes = etNotes.getText().toString().trim();
        String startDate = tvStartDate.getText().toString();
        
        if (childName.isEmpty()) {
            etChildName.setError("Child name is required");
            etChildName.requestFocus();
            return;
        }
        
        if (childAgeStr.isEmpty()) {
            etChildAge.setError("Child age is required");
            etChildAge.requestFocus();
            return;
        }
        
        int childAge;
        try {
            childAge = Integer.parseInt(childAgeStr);
            if (childAge < 0 || childAge > 10) {
                etChildAge.setError("Please enter a valid age (0-10)");
                etChildAge.requestFocus();
                return;
            }
        } catch (NumberFormatException e) {
            etChildAge.setError("Please enter a valid age");
            etChildAge.requestFocus();
            return;
        }
        
        if (parentName.isEmpty()) {
            etParentName.setError("Parent name is required");
            etParentName.requestFocus();
            return;
        }
        
        if (parentPhone.isEmpty()) {
            etParentPhone.setError("Phone number is required");
            etParentPhone.requestFocus();
            return;
        }
        
        if (parentEmail.isEmpty()) {
            etParentEmail.setError("Email is required");
            etParentEmail.requestFocus();
            return;
        }
        
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(parentEmail).matches()) {
            etParentEmail.setError("Please enter a valid email");
            etParentEmail.requestFocus();
            return;
        }
        
        if (startDate.equals("Select Date")) {
            Toast.makeText(this, "Please select a start date", Toast.LENGTH_SHORT).show();
            return;
        }
        
        // Create booking
        Booking booking = new Booking(
            nursery.getId(),
            nursery.getName(),
            childName,
            childAge,
            parentName,
            parentPhone,
            parentEmail,
            startDate,
            selectedPackageType,
            notes
        );
        
        // Save booking
        boolean success = BookingManager.getInstance().addBooking(booking);
        
        if (success) {
            showSuccessDialog();
        } else {
            Toast.makeText(this, R.string.booking_failed, Toast.LENGTH_SHORT).show();
        }
    }
    
    private void showSuccessDialog() {
        new AlertDialog.Builder(this)
            .setTitle("Booking Successful!")
            .setMessage("Your booking request has been submitted successfully. The nursery will contact you shortly to confirm.")
            .setPositiveButton("OK", (dialog, which) -> {
                finish();
            })
            .setCancelable(false)
            .show();
    }
}

