package com.example.h1.activities;

import android.app.Dialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.h1.R;
import com.example.h1.adapters.NurseryAdapter;
import com.example.h1.models.Nursery;
import com.example.h1.utils.FilterHelper;
import com.example.h1.utils.NurseryDataProvider;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    
    private RecyclerView recyclerView;
    private NurseryAdapter adapter;
    private List<Nursery> allNurseries;
    private EditText searchEditText;
    private ImageButton btnFilter, btnSort;
    private TextView tvResultCount;
    private com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton fabQuickSearch;
    
    private FilterHelper.FilterCriteria currentFilter;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        initViews();
        setupRecyclerView();
        setupSearch();
        setupButtons();
        loadNurseries();
    }
    
    private void initViews() {
        recyclerView = findViewById(R.id.recyclerView);
        searchEditText = findViewById(R.id.searchEditText);
        btnFilter = findViewById(R.id.btnFilter);
        btnSort = findViewById(R.id.btnSort);
        tvResultCount = findViewById(R.id.tvResultCount);
        fabQuickSearch = findViewById(R.id.fabQuickSearch);
        
        currentFilter = new FilterHelper.FilterCriteria();
    }
    
    private void setupRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
    }
    
    private void setupSearch() {
        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                currentFilter.searchQuery = s.toString();
                applyFilters();
            }
            
            @Override
            public void afterTextChanged(Editable s) {}
        });
    }
    
    private void setupButtons() {
        btnFilter.setOnClickListener(v -> showFilterDialog());
        btnSort.setOnClickListener(v -> showSortDialog());
        
        fabQuickSearch.setOnClickListener(v -> {
            searchEditText.requestFocus();
            // Show keyboard
            android.view.inputmethod.InputMethodManager imm = (android.view.inputmethod.InputMethodManager) 
                getSystemService(android.content.Context.INPUT_METHOD_SERVICE);
            if (imm != null) {
                imm.showSoftInput(searchEditText, android.view.inputmethod.InputMethodManager.SHOW_IMPLICIT);
            }
        });
    }
    
    private void loadNurseries() {
        allNurseries = NurseryDataProvider.getSampleNurseries();
        adapter = new NurseryAdapter(this, allNurseries);
        recyclerView.setAdapter(adapter);
        updateResultCount(allNurseries.size());
    }
    
    private void applyFilters() {
        List<Nursery> filtered = FilterHelper.filterNurseries(allNurseries, currentFilter);
        adapter.updateList(filtered);
        updateResultCount(filtered.size());
    }
    
    private void updateResultCount(int count) {
        tvResultCount.setText(String.valueOf(count));
    }
    
    private void showFilterDialog() {
        Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_filter);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        
        // Initialize filter controls
        SeekBar seekBarPrice = dialog.findViewById(R.id.seekBarPrice);
        TextView tvPriceValue = dialog.findViewById(R.id.tvPriceValue);
        SeekBar seekBarRating = dialog.findViewById(R.id.seekBarRating);
        TextView tvRatingValue = dialog.findViewById(R.id.tvRatingValue);
        SeekBar seekBarDistance = dialog.findViewById(R.id.seekBarDistance);
        TextView tvDistanceValue = dialog.findViewById(R.id.tvDistanceValue);
        Button btnApply = dialog.findViewById(R.id.btnApply);
        Button btnClear = dialog.findViewById(R.id.btnClear);
        
        // Set initial values
        seekBarPrice.setMax(800);
        seekBarPrice.setProgress((int) currentFilter.maxPrice);
        tvPriceValue.setText((int) currentFilter.maxPrice + " OMR");
        
        seekBarRating.setMax(50); // 5.0 * 10
        seekBarRating.setProgress((int) (currentFilter.minRating * 10));
        tvRatingValue.setText(String.format("%.1f", currentFilter.minRating));
        
        seekBarDistance.setMax(100);
        seekBarDistance.setProgress((int) currentFilter.maxDistance);
        tvDistanceValue.setText((int) currentFilter.maxDistance + " km");
        
        // Setup seekbar listeners
        seekBarPrice.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvPriceValue.setText(progress + " OMR");
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
        
        seekBarRating.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                float rating = progress / 10.0f;
                tvRatingValue.setText(String.format("%.1f", rating));
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
        
        seekBarDistance.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvDistanceValue.setText(progress + " km");
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
        
        btnApply.setOnClickListener(v -> {
            currentFilter.maxPrice = seekBarPrice.getProgress();
            currentFilter.minRating = seekBarRating.getProgress() / 10.0f;
            currentFilter.maxDistance = seekBarDistance.getProgress();
            applyFilters();
            dialog.dismiss();
        });
        
        btnClear.setOnClickListener(v -> {
            currentFilter = new FilterHelper.FilterCriteria();
            searchEditText.setText("");
            applyFilters();
            dialog.dismiss();
        });
        
        dialog.show();
    }
    
    private void showSortDialog() {
        Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_sort);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        
        TextView btnSortRating = dialog.findViewById(R.id.btnSortRating);
        TextView btnSortPriceLow = dialog.findViewById(R.id.btnSortPriceLow);
        TextView btnSortPriceHigh = dialog.findViewById(R.id.btnSortPriceHigh);
        TextView btnSortDistance = dialog.findViewById(R.id.btnSortDistance);
        
        btnSortRating.setOnClickListener(v -> {
            List<Nursery> sorted = FilterHelper.sortByRating(
                FilterHelper.filterNurseries(allNurseries, currentFilter)
            );
            adapter.updateList(sorted);
            dialog.dismiss();
        });
        
        btnSortPriceLow.setOnClickListener(v -> {
            List<Nursery> sorted = FilterHelper.sortByPrice(
                FilterHelper.filterNurseries(allNurseries, currentFilter), true
            );
            adapter.updateList(sorted);
            dialog.dismiss();
        });
        
        btnSortPriceHigh.setOnClickListener(v -> {
            List<Nursery> sorted = FilterHelper.sortByPrice(
                FilterHelper.filterNurseries(allNurseries, currentFilter), false
            );
            adapter.updateList(sorted);
            dialog.dismiss();
        });
        
        btnSortDistance.setOnClickListener(v -> {
            List<Nursery> sorted = FilterHelper.sortByDistance(
                FilterHelper.filterNurseries(allNurseries, currentFilter)
            );
            adapter.updateList(sorted);
            dialog.dismiss();
        });
        
        dialog.show();
    }
}

