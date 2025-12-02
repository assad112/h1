package com.example.h1.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.h1.R;
import com.example.h1.utils.AdminManager;
import com.example.h1.database.DatabaseHelper;

public class AdminLoginActivity extends AppCompatActivity {
    
    private EditText etUsername, etPassword;
    private Button btnLogin;
    private DatabaseHelper databaseHelper;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        
        databaseHelper = new DatabaseHelper(this);
        
        initViews();
        setupLogin();
    }
    
    private void initViews() {
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
    }
    
    private void setupLogin() {
        btnLogin.setOnClickListener(v -> {
            String email = etUsername.getText().toString().trim();
            String password = etPassword.getText().toString().trim();
            
            if (email.isEmpty()) {
                etUsername.setError("البريد الإلكتروني مطلوب");
                etUsername.requestFocus();
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
                
                if ("admin".equals(userType)) {
                    AdminManager.getInstance().login(email, password);
                    Toast.makeText(this, "تم تسجيل الدخول بنجاح", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(this, AdminDashboardActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(this, "هذا الحساب ليس حساب أدمن", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "البريد الإلكتروني أو كلمة المرور غير صحيحة", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

