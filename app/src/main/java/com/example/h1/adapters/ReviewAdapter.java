package com.example.h1.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.h1.R;
import com.example.h1.models.Review;

import java.util.List;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ReviewViewHolder> {
    
    private Context context;
    private List<Review> reviews;
    
    public ReviewAdapter(Context context, List<Review> reviews) {
        this.context = context;
        this.reviews = reviews;
    }
    
    @NonNull
    @Override
    public ReviewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_review, parent, false);
        return new ReviewViewHolder(view);
    }
    
    @Override
    public void onBindViewHolder(@NonNull ReviewViewHolder holder, int position) {
        Review review = reviews.get(position);
        
        holder.tvUserName.setText(review.getUserName());
        holder.tvRating.setText(String.valueOf(review.getRating()));
        holder.tvComment.setText(review.getComment());
        holder.tvDate.setText(review.getDate());
        
        if (review.isVerified()) {
            holder.tvVerified.setVisibility(View.VISIBLE);
        } else {
            holder.tvVerified.setVisibility(View.GONE);
        }
    }
    
    @Override
    public int getItemCount() {
        return reviews.size();
    }
    
    static class ReviewViewHolder extends RecyclerView.ViewHolder {
        TextView tvUserName, tvRating, tvComment, tvDate, tvVerified;
        
        public ReviewViewHolder(@NonNull View itemView) {
            super(itemView);
            tvUserName = itemView.findViewById(R.id.tvUserName);
            tvRating = itemView.findViewById(R.id.tvRating);
            tvComment = itemView.findViewById(R.id.tvComment);
            tvDate = itemView.findViewById(R.id.tvDate);
            tvVerified = itemView.findViewById(R.id.tvVerified);
        }
    }
}

