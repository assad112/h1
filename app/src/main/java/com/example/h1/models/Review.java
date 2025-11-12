package com.example.h1.models;

import java.io.Serializable;

public class Review implements Serializable {
    private int id;
    private int nurseryId;
    private String userName;
    private float rating;
    private String comment;
    private String date;
    private boolean isVerified;

    public Review() {
    }

    public Review(int id, int nurseryId, String userName, float rating, String comment, String date) {
        this.id = id;
        this.nurseryId = nurseryId;
        this.userName = userName;
        this.rating = rating;
        this.comment = comment;
        this.date = date;
        this.isVerified = false;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNurseryId() {
        return nurseryId;
    }

    public void setNurseryId(int nurseryId) {
        this.nurseryId = nurseryId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean verified) {
        isVerified = verified;
    }
}

