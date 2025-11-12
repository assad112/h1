package com.example.h1.utils;

import com.example.h1.models.Booking;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class BookingManager {
    private static BookingManager instance;
    private List<Booking> bookings;
    private int nextId;
    
    private BookingManager() {
        bookings = new ArrayList<>();
        nextId = 1;
    }
    
    public static BookingManager getInstance() {
        if (instance == null) {
            instance = new BookingManager();
        }
        return instance;
    }
    
    public boolean addBooking(Booking booking) {
        try {
            booking.setId(nextId++);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
            booking.setBookingDate(sdf.format(new Date()));
            bookings.add(booking);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public List<Booking> getAllBookings() {
        return new ArrayList<>(bookings);
    }
    
    public List<Booking> getBookingsByNursery(int nurseryId) {
        List<Booking> nurseryBookings = new ArrayList<>();
        for (Booking booking : bookings) {
            if (booking.getNurseryId() == nurseryId) {
                nurseryBookings.add(booking);
            }
        }
        return nurseryBookings;
    }
    
    public Booking getBookingById(int id) {
        for (Booking booking : bookings) {
            if (booking.getId() == id) {
                return booking;
            }
        }
        return null;
    }
    
    public boolean updateBookingStatus(int id, String status) {
        Booking booking = getBookingById(id);
        if (booking != null) {
            booking.setStatus(status);
            return true;
        }
        return false;
    }
}

