package com.example.h1.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.h1.R;
import com.example.h1.adapters.ReviewAdapter;
import com.example.h1.models.Nursery;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

public class NurseryDetailsActivity extends AppCompatActivity {
    
    private Nursery nursery;
    private TextView tvName, tvRating, tvReviewCount, tvDistance, tvPrice, tvAgeRange;
    private TextView tvOpeningHours, tvAddress, tvPhone, tvEmail, tvDescription;
    private TextView tvCapacity, tvAvailableSlots;
    private ChipGroup chipGroupFacilities;
    private RecyclerView reviewsRecyclerView;
    private Button btnBookNow, btnCallNow, btnViewLocation;
    private ImageButton btnBack;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nursery_details);
        
        // Get nursery from intent
        nursery = (Nursery) getIntent().getSerializableExtra("nursery");
        
        if (nursery == null) {
            Toast.makeText(this, "Error loading nursery details", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }
        
        initViews();
        displayNurseryDetails();
        setupButtons();
        setupReviews();
    }
    
    private void initViews() {
        btnBack = findViewById(R.id.btnBack);
        tvName = findViewById(R.id.tvNurseryName);
        tvRating = findViewById(R.id.tvRating);
        tvReviewCount = findViewById(R.id.tvReviewCount);
        tvDistance = findViewById(R.id.tvDistance);
        tvPrice = findViewById(R.id.tvPrice);
        tvAgeRange = findViewById(R.id.tvAgeRange);
        tvOpeningHours = findViewById(R.id.tvOpeningHours);
        tvAddress = findViewById(R.id.tvAddress);
        tvPhone = findViewById(R.id.tvPhone);
        tvEmail = findViewById(R.id.tvEmail);
        tvDescription = findViewById(R.id.tvDescription);
        tvCapacity = findViewById(R.id.tvCapacity);
        tvAvailableSlots = findViewById(R.id.tvAvailableSlots);
        chipGroupFacilities = findViewById(R.id.chipGroupFacilities);
        reviewsRecyclerView = findViewById(R.id.reviewsRecyclerView);
        btnBookNow = findViewById(R.id.btnBookNow);
        btnCallNow = findViewById(R.id.btnCallNow);
        btnViewLocation = findViewById(R.id.btnViewLocation);
    }
    
    private void displayNurseryDetails() {
        tvName.setText(nursery.getName());
        tvRating.setText(String.valueOf(nursery.getRating()));
        tvReviewCount.setText("(" + nursery.getReviewCount() + " reviews)");
        tvDistance.setText(nursery.getDistanceFormatted());
        tvPrice.setText(nursery.getPriceFormatted());
        tvAgeRange.setText(nursery.getAgeRange());
        tvOpeningHours.setText(nursery.getOpeningHours());
        tvAddress.setText(nursery.getAddress());
        tvPhone.setText(nursery.getPhone());
        tvEmail.setText(nursery.getEmail());
        tvDescription.setText(nursery.getDescription());
        tvCapacity.setText("Capacity: " + nursery.getCapacity() + " children");
        tvAvailableSlots.setText("Available: " + nursery.getAvailableSlots() + " slots");
        
        // Add facilities as chips
        chipGroupFacilities.removeAllViews();
        for (String facility : nursery.getFacilities()) {
            Chip chip = new Chip(this);
            chip.setText(facility);
            chip.setClickable(false);
            chip.setChipBackgroundColorResource(R.color.primary_light);
            chipGroupFacilities.addView(chip);
        }
        
        // Disable book button if no slots available
        if (nursery.getAvailableSlots() == 0) {
            btnBookNow.setEnabled(false);
            btnBookNow.setText("Fully Booked");
        }
    }
    
    private void setupButtons() {
        btnBack.setOnClickListener(v -> finish());
        
        btnBookNow.setOnClickListener(v -> {
            Intent intent = new Intent(this, BookingActivity.class);
            intent.putExtra("nursery", nursery);
            startActivity(intent);
        });
        
        btnCallNow.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + nursery.getPhone()));
            startActivity(intent);
        });
        
        btnViewLocation.setOnClickListener(v -> {
            // Open maps with address
            Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + Uri.encode(nursery.getAddress()));
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            if (mapIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(mapIntent);
            } else {
                Toast.makeText(this, "No maps application found", Toast.LENGTH_SHORT).show();
            }
        });
    }
    
    private void setupReviews() {
        reviewsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        ReviewAdapter reviewAdapter = new ReviewAdapter(this, nursery.getReviews());
        reviewsRecyclerView.setAdapter(reviewAdapter);
        reviewsRecyclerView.setNestedScrollingEnabled(false);
    }
}







