package com.example.h1.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.h1.R;
import com.example.h1.adapters.AdminReviewAdapter;
import com.example.h1.models.Review;
import com.example.h1.utils.AdminManager;
import com.example.h1.database.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;

public class AdminReviewsActivity extends AppCompatActivity {
    
    private RecyclerView recyclerView;
    private AdminReviewAdapter adapter;
    private List<Review> allReviews;
    private DatabaseHelper databaseHelper;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_reviews);
        
        if (!AdminManager.getInstance().isLoggedIn()) {
            Intent intent = new Intent(this, AdminLoginActivity.class);
            startActivity(intent);
            finish();
            return;
        }
        
        databaseHelper = new DatabaseHelper(this);
        
        initViews();
        setupToolbar();
        loadAllReviews();
        setupRecyclerView();
    }
    
    private void initViews() {
        recyclerView = findViewById(R.id.recyclerView);
    }
    
    private void setupToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("التعليقات والتقييمات");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }
    
    private void loadAllReviews() {
        allReviews = databaseHelper.getAllReviews();
    }
    
    private void setupRecyclerView() {
        adapter = new AdminReviewAdapter(this, allReviews);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

