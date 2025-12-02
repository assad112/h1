package com.example.h1.utils;

public class AdminManager {
    private static AdminManager instance;
    private boolean isAdminLoggedIn = false;
    
    // Admin credentials (في التطبيق الحقيقي يجب تخزينها بشكل آمن)
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin123";
    
    private AdminManager() {}
    
    public static AdminManager getInstance() {
        if (instance == null) {
            instance = new AdminManager();
        }
        return instance;
    }
    
    public boolean login(String username, String password) {
        if (ADMIN_USERNAME.equals(username) && ADMIN_PASSWORD.equals(password)) {
            isAdminLoggedIn = true;
            return true;
        }
        return false;
    }
    
    public void logout() {
        isAdminLoggedIn = false;
    }
    
    public boolean isLoggedIn() {
        return isAdminLoggedIn;
    }
}

