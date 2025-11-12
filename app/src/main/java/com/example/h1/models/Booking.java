package com.example.h1.models;

import java.io.Serializable;

public class Booking implements Serializable {
    private int id;
    private int nurseryId;
    private String nurseryName;
    private String childName;
    private int childAge;
    private String parentName;
    private String parentPhone;
    private String parentEmail;
    private String startDate;
    private String packageType; // FULL_TIME, PART_TIME, HOURLY
    private String additionalNotes;
    private String bookingDate;
    private String status; // PENDING, CONFIRMED, CANCELLED

    public Booking() {
        this.status = "PENDING";
    }

    public Booking(int nurseryId, String nurseryName, String childName, int childAge, 
                   String parentName, String parentPhone, String parentEmail, 
                   String startDate, String packageType, String additionalNotes) {
        this.nurseryId = nurseryId;
        this.nurseryName = nurseryName;
        this.childName = childName;
        this.childAge = childAge;
        this.parentName = parentName;
        this.parentPhone = parentPhone;
        this.parentEmail = parentEmail;
        this.startDate = startDate;
        this.packageType = packageType;
        this.additionalNotes = additionalNotes;
        this.status = "PENDING";
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

    public String getNurseryName() {
        return nurseryName;
    }

    public void setNurseryName(String nurseryName) {
        this.nurseryName = nurseryName;
    }

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    public int getChildAge() {
        return childAge;
    }

    public void setChildAge(int childAge) {
        this.childAge = childAge;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getParentPhone() {
        return parentPhone;
    }

    public void setParentPhone(String parentPhone) {
        this.parentPhone = parentPhone;
    }

    public String getParentEmail() {
        return parentEmail;
    }

    public void setParentEmail(String parentEmail) {
        this.parentEmail = parentEmail;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getPackageType() {
        return packageType;
    }

    public void setPackageType(String packageType) {
        this.packageType = packageType;
    }

    public String getAdditionalNotes() {
        return additionalNotes;
    }

    public void setAdditionalNotes(String additionalNotes) {
        this.additionalNotes = additionalNotes;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

