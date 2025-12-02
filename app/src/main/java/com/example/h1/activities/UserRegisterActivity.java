package com.example.h1.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.h1.R;
import com.example.h1.database.DatabaseHelper;

public class UserRegisterActivity extends AppCompatActivity {
    
    private EditText etName, etEmail, etPassword, etConfirmPassword, etPhone;
    private Button btnRegister;
    private TextView tvLogin;
    private DatabaseHelper databaseHelper;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_register);
        
        databaseHelper = new DatabaseHelper(this);
        
        initViews();
        setupRegister();
        setupLogin();
    }
    
    private void initViews() {
        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        etPhone = findViewById(R.id.etPhone);
        btnRegister = findViewById(R.id.btnRegister);
        tvLogin = findViewById(R.id.tvLogin);
    }
    
    private void setupRegister() {
        btnRegister.setOnClickListener(v -> {
            String name = etName.getText().toString().trim();
            String email = etEmail.getText().toString().trim();
            String password = etPassword.getText().toString().trim();
            String confirmPassword = etConfirmPassword.getText().toString().trim();
            String phone = etPhone.getText().toString().trim();
            
            // Validation
            if (name.isEmpty()) {
                etName.setError("الاسم مطلوب");
                etName.requestFocus();
                return;
            }
            
            if (email.isEmpty()) {
                etEmail.setError("البريد الإلكتروني مطلوب");
                etEmail.requestFocus();
                return;
            }
            
            if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                etEmail.setError("البريد الإلكتروني غير صحيح");
                etEmail.requestFocus();
                return;
            }
            
            if (password.isEmpty()) {
                etPassword.setError("كلمة المرور مطلوبة");
                etPassword.requestFocus();
                return;
            }
            
            if (password.length() < 6) {
                etPassword.setError("كلمة المرور يجب أن تكون 6 أحرف على الأقل");
                etPassword.requestFocus();
                return;
            }
            
            if (!password.equals(confirmPassword)) {
                etConfirmPassword.setError("كلمة المرور غير متطابقة");
                etConfirmPassword.requestFocus();
                return;
            }
            
            if (phone.isEmpty()) {
                etPhone.setError("رقم الهاتف مطلوب");
                etPhone.requestFocus();
                return;
            }
            
            // Register user
            long userId = databaseHelper.addUser(name, email, password, phone, "user");
            
            if (userId > 0) {
                Toast.makeText(this, "تم التسجيل بنجاح!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, UserLoginActivity.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(this, "فشل التسجيل. البريد الإلكتروني مستخدم بالفعل", Toast.LENGTH_SHORT).show();
            }
        });
    }
    
    private void setupLogin() {
        tvLogin.setOnClickListener(v -> {
            finish();
        });
    }
}

