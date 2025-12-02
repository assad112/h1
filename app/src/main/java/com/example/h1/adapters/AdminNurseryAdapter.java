package com.example.h1.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.h1.R;
import com.example.h1.models.Nursery;

import java.util.List;

public class AdminNurseryAdapter extends RecyclerView.Adapter<AdminNurseryAdapter.ViewHolder> {
    
    private Context context;
    private List<Nursery> nurseries;
    private OnNurseryActionListener listener;
    
    public interface OnNurseryActionListener {
        void onEdit(Nursery nursery);
        void onDelete(Nursery nursery);
    }
    
    public AdminNurseryAdapter(Context context, List<Nursery> nurseries, OnNurseryActionListener listener) {
        this.context = context;
        this.nurseries = nurseries;
        this.listener = listener;
    }
    
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_admin_nursery, parent, false);
        return new ViewHolder(view);
    }
    
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Nursery nursery = nurseries.get(position);
        holder.tvName.setText(nursery.getName());
        holder.tvAddress.setText(nursery.getAddress());
        holder.tvPhone.setText(nursery.getPhone());
        holder.tvRating.setText(String.format("%.1f", nursery.getRating()));
        holder.tvPrice.setText(nursery.getPriceFormatted());
        
        holder.btnEdit.setOnClickListener(v -> {
            if (listener != null) {
                listener.onEdit(nursery);
            }
        });
        
        holder.btnDelete.setOnClickListener(v -> {
            if (listener != null) {
                listener.onDelete(nursery);
            }
        });
    }
    
    @Override
    public int getItemCount() {
        return nurseries.size();
    }
    
    public void updateList(List<Nursery> newList) {
        this.nurseries = newList;
        notifyDataSetChanged();
    }
    
    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvAddress, tvPhone, tvRating, tvPrice;
        Button btnEdit, btnDelete;
        
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvAddress = itemView.findViewById(R.id.tvAddress);
            tvPhone = itemView.findViewById(R.id.tvPhone);
            tvRating = itemView.findViewById(R.id.tvRating);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            btnEdit = itemView.findViewById(R.id.btnEdit);
            btnDelete = itemView.findViewById(R.id.btnDelete);
        }
    }
}

