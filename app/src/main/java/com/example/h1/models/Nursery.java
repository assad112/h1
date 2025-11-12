package com.example.h1.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Nursery implements Serializable {
    private int id;
    private String name;
    private String description;
    private String address;
    private String phone;
    private String email;
    private double latitude;
    private double longitude;
    private float rating;
    private int reviewCount;
    private double pricePerMonth;
    private String ageRange;
    private String openingHours;
    private double distance; // in kilometers
    private String imageUrl;
    private List<String> facilities;
    private List<Review> reviews;
    private boolean isVerified;
    private int capacity;
    private int availableSlots;

    public Nursery() {
        this.facilities = new ArrayList<>();
        this.reviews = new ArrayList<>();
    }

    public Nursery(int id, String name, String description, String address, String phone, 
                   String email, double latitude, double longitude, float rating, 
                   int reviewCount, double pricePerMonth, String ageRange, 
                   String openingHours, double distance, String imageUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.latitude = latitude;
        this.longitude = longitude;
        this.rating = rating;
        this.reviewCount = reviewCount;
        this.pricePerMonth = pricePerMonth;
        this.ageRange = ageRange;
        this.openingHours = openingHours;
        this.distance = distance;
        this.imageUrl = imageUrl;
        this.facilities = new ArrayList<>();
        this.reviews = new ArrayList<>();
        this.isVerified = true;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(int reviewCount) {
        this.reviewCount = reviewCount;
    }

    public double getPricePerMonth() {
        return pricePerMonth;
    }

    public void setPricePerMonth(double pricePerMonth) {
        this.pricePerMonth = pricePerMonth;
    }

    public String getAgeRange() {
        return ageRange;
    }

    public void setAgeRange(String ageRange) {
        this.ageRange = ageRange;
    }

    public String getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<String> getFacilities() {
        return facilities;
    }

    public void setFacilities(List<String> facilities) {
        this.facilities = facilities;
    }

    public void addFacility(String facility) {
        this.facilities.add(facility);
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public void addReview(Review review) {
        this.reviews.add(review);
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean verified) {
        isVerified = verified;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getAvailableSlots() {
        return availableSlots;
    }

    public void setAvailableSlots(int availableSlots) {
        this.availableSlots = availableSlots;
    }

    public String getPriceFormatted() {
        return String.format("%.0f OMR/month", pricePerMonth);
    }

    public String getDistanceFormatted() {
        return String.format("%.1f km", distance);
    }

    public String getRatingText() {
        return String.format("%.1f (%d reviews)", rating, reviewCount);
    }
}

