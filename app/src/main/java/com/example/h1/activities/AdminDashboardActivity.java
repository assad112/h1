package com.example.h1.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.h1.R;
import com.example.h1.utils.AdminManager;

public class AdminDashboardActivity extends AppCompatActivity {
    
    private Button btnManageNurseries, btnViewReviews;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);
        
        // Check if admin is logged in
        if (!AdminManager.getInstance().isLoggedIn()) {
            Intent intent = new Intent(this, AdminLoginActivity.class);
            startActivity(intent);
            finish();
            return;
        }
        
        initViews();
        setupToolbar();
        setupButtons();
    }
    
    private void initViews() {
        btnManageNurseries = findViewById(R.id.btnManageNurseries);
        btnViewReviews = findViewById(R.id.btnViewReviews);
    }
    
    private void setupToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("لوحة تحكم الأدمن");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }
    
    private void setupButtons() {
        btnManageNurseries.setOnClickListener(v -> {
            Intent intent = new Intent(this, AdminManageNurseriesActivity.class);
            startActivity(intent);
        });
        
        btnViewReviews.setOnClickListener(v -> {
            Intent intent = new Intent(this, AdminReviewsActivity.class);
            startActivity(intent);
        });
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.admin_menu, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_logout) {
            AdminManager.getInstance().logout();
            Intent intent = new Intent(this, AdminLoginActivity.class);
            startActivity(intent);
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

