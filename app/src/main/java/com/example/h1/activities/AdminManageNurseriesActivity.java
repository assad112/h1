package com.example.h1.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.h1.R;
import com.example.h1.adapters.AdminNurseryAdapter;
import com.example.h1.models.Nursery;
import com.example.h1.utils.AdminManager;
import com.example.h1.database.DatabaseHelper;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class AdminManageNurseriesActivity extends AppCompatActivity {
    
    private RecyclerView recyclerView;
    private AdminNurseryAdapter adapter;
    private List<Nursery> nurseries;
    private FloatingActionButton fabAdd;
    private DatabaseHelper databaseHelper;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_manage_nurseries);
        
        if (!AdminManager.getInstance().isLoggedIn()) {
            Intent intent = new Intent(this, AdminLoginActivity.class);
            startActivity(intent);
            finish();
            return;
        }
        
        databaseHelper = new DatabaseHelper(this);
        
        initViews();
        setupToolbar();
        loadNurseries();
        setupRecyclerView();
        setupFab();
    }
    
    private void initViews() {
        recyclerView = findViewById(R.id.recyclerView);
        fabAdd = findViewById(R.id.fabAdd);
    }
    
    private void setupToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("إدارة الحضانات");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }
    
    private void loadNurseries() {
        nurseries = databaseHelper.getAllNurseries();
    }
    
    private void setupRecyclerView() {
        adapter = new AdminNurseryAdapter(this, nurseries, new AdminNurseryAdapter.OnNurseryActionListener() {
            @Override
            public void onEdit(Nursery nursery) {
                // TODO: Open edit dialog
                Toast.makeText(AdminManageNurseriesActivity.this, "تعديل: " + nursery.getName(), Toast.LENGTH_SHORT).show();
            }
            
            @Override
            public void onDelete(Nursery nursery) {
                showDeleteConfirmDialog(nursery);
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
    
    private void setupFab() {
        fabAdd.setOnClickListener(v -> {
            // TODO: Open add dialog
            Toast.makeText(this, "إضافة حضانة جديدة", Toast.LENGTH_SHORT).show();
        });
    }
    
    private void showDeleteConfirmDialog(Nursery nursery) {
        new AlertDialog.Builder(this)
            .setTitle("تأكيد الحذف")
            .setMessage("هل أنت متأكد من حذف " + nursery.getName() + "؟")
            .setPositiveButton("حذف", (dialog, which) -> {
                databaseHelper.deleteNursery(nursery.getId());
                nurseries.remove(nursery);
                adapter.notifyDataSetChanged();
                Toast.makeText(this, "تم الحذف بنجاح", Toast.LENGTH_SHORT).show();
            })
            .setNegativeButton("إلغاء", null)
            .show();
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

