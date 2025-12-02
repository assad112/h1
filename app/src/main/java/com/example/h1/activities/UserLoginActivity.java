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

public class UserLoginActivity extends AppCompatActivity {
    
    private EditText etEmail, etPassword;
    private Button btnLogin;
    private TextView tvRegister, tvSkip;
    private DatabaseHelper databaseHelper;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        
        databaseHelper = new DatabaseHelper(this);
        
        initViews();
        setupLogin();
        setupRegister();
        setupSkip();
    }
    
    private void initViews() {
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        tvRegister = findViewById(R.id.tvRegister);
        tvSkip = findViewById(R.id.tvSkip);
    }
    
    private void setupLogin() {
        btnLogin.setOnClickListener(v -> {
            String email = etEmail.getText().toString().trim();
            String password = etPassword.getText().toString().trim();
            
            if (email.isEmpty()) {
                etEmail.setError("البريد الإلكتروني مطلوب");
                etEmail.requestFocus();
                return;
            }
            
            if (password.isEmpty()) {
                etPassword.setError("كلمة المرور مطلوبة");
                etPassword.requestFocus();
                return;
            }
            
            // التحقق من قاعدة البيانات
            boolean success = databaseHelper.checkUserLogin(email, password);
            
            if (success) {
                String userType = databaseHelper.getUserType(email);
                
                if ("user".equals(userType)) {
                    Toast.makeText(this, "مرحباً بك!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(this, "هذا حساب أدمن. استخدم تسجيل دخول الأدمن", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "البريد الإلكتروني أو كلمة المرور غير صحيحة", Toast.LENGTH_SHORT).show();
            }
        });
    }
    
    private void setupRegister() {
        tvRegister.setOnClickListener(v -> {
            Intent intent = new Intent(this, UserRegisterActivity.class);
            startActivity(intent);
        });
    }
    
    private void setupSkip() {
        tvSkip.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}

