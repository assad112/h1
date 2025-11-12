package com.example.h1.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.h1.R;
import com.example.h1.activities.NurseryDetailsActivity;
import com.example.h1.models.Nursery;

import java.util.ArrayList;
import java.util.List;

public class NurseryAdapter extends RecyclerView.Adapter<NurseryAdapter.NurseryViewHolder> {
    
    private Context context;
    private List<Nursery> nurseries;
    private List<Nursery> nurseriesFiltered;
    
    public NurseryAdapter(Context context, List<Nursery> nurseries) {
        this.context = context;
        this.nurseries = nurseries;
        this.nurseriesFiltered = new ArrayList<>(nurseries);
    }
    
    @NonNull
    @Override
    public NurseryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_nursery, parent, false);
        return new NurseryViewHolder(view);
    }
    
    @Override
    public void onBindViewHolder(@NonNull NurseryViewHolder holder, int position) {
        Nursery nursery = nurseriesFiltered.get(position);
        
        holder.tvName.setText(nursery.getName());
        holder.tvAddress.setText(nursery.getAddress());
        holder.tvPrice.setText(nursery.getPriceFormatted());
        holder.tvDistance.setText(nursery.getDistanceFormatted());
        holder.tvRating.setText(String.valueOf(nursery.getRating()));
        holder.tvReviewCount.setText("(" + nursery.getReviewCount() + ")");
        holder.tvAgeRange.setText(nursery.getAgeRange());
        
        // Show available slots
        if (nursery.getAvailableSlots() > 0) {
            holder.tvAvailability.setText(nursery.getAvailableSlots() + " Slots");
            holder.tvAvailability.setVisibility(android.view.View.VISIBLE);
        } else {
            holder.tvAvailability.setText("Full");
            holder.tvAvailability.setVisibility(android.view.View.VISIBLE);
        }
        
        // Click listener to open details
        holder.cardView.setOnClickListener(v -> {
            Intent intent = new Intent(context, NurseryDetailsActivity.class);
            intent.putExtra("nursery", nursery);
            context.startActivity(intent);
        });
    }
    
    @Override
    public int getItemCount() {
        return nurseriesFiltered.size();
    }
    
    public void updateList(List<Nursery> newList) {
        this.nurseriesFiltered = new ArrayList<>(newList);
        notifyDataSetChanged();
    }
    
    public void filter(String query) {
        nurseriesFiltered.clear();
        if (query.isEmpty()) {
            nurseriesFiltered.addAll(nurseries);
        } else {
            String lowerCaseQuery = query.toLowerCase();
            for (Nursery nursery : nurseries) {
                if (nursery.getName().toLowerCase().contains(lowerCaseQuery) ||
                    nursery.getAddress().toLowerCase().contains(lowerCaseQuery) ||
                    nursery.getDescription().toLowerCase().contains(lowerCaseQuery)) {
                    nurseriesFiltered.add(nursery);
                }
            }
        }
        notifyDataSetChanged();
    }
    
    static class NurseryViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView tvName, tvAddress, tvPrice, tvDistance, tvRating, tvReviewCount, tvAgeRange, tvAvailability;
        
        public NurseryViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardView);
            tvName = itemView.findViewById(R.id.tvNurseryName);
            tvAddress = itemView.findViewById(R.id.tvAddress);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            tvDistance = itemView.findViewById(R.id.tvDistance);
            tvRating = itemView.findViewById(R.id.tvRating);
            tvReviewCount = itemView.findViewById(R.id.tvReviewCount);
            tvAgeRange = itemView.findViewById(R.id.tvAgeRange);
            tvAvailability = itemView.findViewById(R.id.tvAvailability);
        }
    }
}

