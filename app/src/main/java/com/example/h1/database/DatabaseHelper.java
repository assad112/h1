package com.example.h1.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.h1.models.Nursery;
import com.example.h1.models.Review;
import com.example.h1.models.Booking;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    
    private static final String DATABASE_NAME = "nursery_app.db";
    private static final int DATABASE_VERSION = 1;
    
    // جدول المستخدمين
    private static final String TABLE_USERS = "users";
    private static final String COL_USER_ID = "user_id";
    private static final String COL_USER_NAME = "user_name";
    private static final String COL_USER_EMAIL = "user_email";
    private static final String COL_USER_PASSWORD = "user_password";
    private static final String COL_USER_PHONE = "user_phone";
    private static final String COL_USER_TYPE = "user_type"; // admin or user
    
    // جدول الحضانات
    private static final String TABLE_NURSERIES = "nurseries";
    private static final String COL_NURSERY_ID = "nursery_id";
    private static final String COL_NURSERY_NAME = "name";
    private static final String COL_NURSERY_DESC = "description";
    private static final String COL_NURSERY_ADDRESS = "address";
    private static final String COL_NURSERY_PHONE = "phone";
    private static final String COL_NURSERY_EMAIL = "email";
    private static final String COL_NURSERY_LAT = "latitude";
    private static final String COL_NURSERY_LNG = "longitude";
    private static final String COL_NURSERY_RATING = "rating";
    private static final String COL_NURSERY_REVIEW_COUNT = "review_count";
    private static final String COL_NURSERY_PRICE = "price_per_month";
    private static final String COL_NURSERY_AGE_RANGE = "age_range";
    private static final String COL_NURSERY_HOURS = "opening_hours";
    private static final String COL_NURSERY_DISTANCE = "distance";
    private static final String COL_NURSERY_IMAGE = "image_url";
    private static final String COL_NURSERY_VERIFIED = "is_verified";
    private static final String COL_NURSERY_CAPACITY = "capacity";
    private static final String COL_NURSERY_SLOTS = "available_slots";
    
    // جدول التقييمات
    private static final String TABLE_REVIEWS = "reviews";
    private static final String COL_REVIEW_ID = "review_id";
    private static final String COL_REVIEW_NURSERY_ID = "nursery_id";
    private static final String COL_REVIEW_USER_NAME = "user_name";
    private static final String COL_REVIEW_RATING = "rating";
    private static final String COL_REVIEW_COMMENT = "comment";
    private static final String COL_REVIEW_DATE = "date";
    private static final String COL_REVIEW_VERIFIED = "is_verified";
    
    // جدول الحجوزات
    private static final String TABLE_BOOKINGS = "bookings";
    private static final String COL_BOOKING_ID = "booking_id";
    private static final String COL_BOOKING_NURSERY_ID = "nursery_id";
    private static final String COL_BOOKING_NURSERY_NAME = "nursery_name";
    private static final String COL_BOOKING_CHILD_NAME = "child_name";
    private static final String COL_BOOKING_CHILD_AGE = "child_age";
    private static final String COL_BOOKING_PARENT_NAME = "parent_name";
    private static final String COL_BOOKING_PARENT_PHONE = "parent_phone";
    private static final String COL_BOOKING_PARENT_EMAIL = "parent_email";
    private static final String COL_BOOKING_START_DATE = "start_date";
    private static final String COL_BOOKING_PACKAGE_TYPE = "package_type";
    private static final String COL_BOOKING_NOTES = "additional_notes";
    private static final String COL_BOOKING_DATE = "booking_date";
    private static final String COL_BOOKING_STATUS = "status";
    
    // جدول المرافق
    private static final String TABLE_FACILITIES = "facilities";
    private static final String COL_FACILITY_ID = "facility_id";
    private static final String COL_FACILITY_NURSERY_ID = "nursery_id";
    private static final String COL_FACILITY_NAME = "facility_name";
    
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    
    @Override
    public void onCreate(SQLiteDatabase db) {
        // إنشاء جدول المستخدمين
        String createUsersTable = "CREATE TABLE " + TABLE_USERS + " (" +
                COL_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_USER_NAME + " TEXT NOT NULL, " +
                COL_USER_EMAIL + " TEXT UNIQUE NOT NULL, " +
                COL_USER_PASSWORD + " TEXT NOT NULL, " +
                COL_USER_PHONE + " TEXT, " +
                COL_USER_TYPE + " TEXT NOT NULL DEFAULT 'user')";
        db.execSQL(createUsersTable);
        
        // إنشاء جدول الحضانات
        String createNurseriesTable = "CREATE TABLE " + TABLE_NURSERIES + " (" +
                COL_NURSERY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_NURSERY_NAME + " TEXT NOT NULL, " +
                COL_NURSERY_DESC + " TEXT, " +
                COL_NURSERY_ADDRESS + " TEXT, " +
                COL_NURSERY_PHONE + " TEXT, " +
                COL_NURSERY_EMAIL + " TEXT, " +
                COL_NURSERY_LAT + " REAL, " +
                COL_NURSERY_LNG + " REAL, " +
                COL_NURSERY_RATING + " REAL DEFAULT 0, " +
                COL_NURSERY_REVIEW_COUNT + " INTEGER DEFAULT 0, " +
                COL_NURSERY_PRICE + " REAL, " +
                COL_NURSERY_AGE_RANGE + " TEXT, " +
                COL_NURSERY_HOURS + " TEXT, " +
                COL_NURSERY_DISTANCE + " REAL, " +
                COL_NURSERY_IMAGE + " TEXT, " +
                COL_NURSERY_VERIFIED + " INTEGER DEFAULT 1, " +
                COL_NURSERY_CAPACITY + " INTEGER, " +
                COL_NURSERY_SLOTS + " INTEGER)";
        db.execSQL(createNurseriesTable);
        
        // إنشاء جدول التقييمات
        String createReviewsTable = "CREATE TABLE " + TABLE_REVIEWS + " (" +
                COL_REVIEW_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_REVIEW_NURSERY_ID + " INTEGER, " +
                COL_REVIEW_USER_NAME + " TEXT, " +
                COL_REVIEW_RATING + " REAL, " +
                COL_REVIEW_COMMENT + " TEXT, " +
                COL_REVIEW_DATE + " TEXT, " +
                COL_REVIEW_VERIFIED + " INTEGER DEFAULT 1, " +
                "FOREIGN KEY(" + COL_REVIEW_NURSERY_ID + ") REFERENCES " + 
                TABLE_NURSERIES + "(" + COL_NURSERY_ID + "))";
        db.execSQL(createReviewsTable);
        
        // إنشاء جدول الحجوزات
        String createBookingsTable = "CREATE TABLE " + TABLE_BOOKINGS + " (" +
                COL_BOOKING_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_BOOKING_NURSERY_ID + " INTEGER, " +
                COL_BOOKING_NURSERY_NAME + " TEXT, " +
                COL_BOOKING_CHILD_NAME + " TEXT, " +
                COL_BOOKING_CHILD_AGE + " INTEGER, " +
                COL_BOOKING_PARENT_NAME + " TEXT, " +
                COL_BOOKING_PARENT_PHONE + " TEXT, " +
                COL_BOOKING_PARENT_EMAIL + " TEXT, " +
                COL_BOOKING_START_DATE + " TEXT, " +
                COL_BOOKING_PACKAGE_TYPE + " TEXT, " +
                COL_BOOKING_NOTES + " TEXT, " +
                COL_BOOKING_DATE + " TEXT, " +
                COL_BOOKING_STATUS + " TEXT DEFAULT 'PENDING', " +
                "FOREIGN KEY(" + COL_BOOKING_NURSERY_ID + ") REFERENCES " + 
                TABLE_NURSERIES + "(" + COL_NURSERY_ID + "))";
        db.execSQL(createBookingsTable);
        
        // إنشاء جدول المرافق
        String createFacilitiesTable = "CREATE TABLE " + TABLE_FACILITIES + " (" +
                COL_FACILITY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_FACILITY_NURSERY_ID + " INTEGER, " +
                COL_FACILITY_NAME + " TEXT, " +
                "FOREIGN KEY(" + COL_FACILITY_NURSERY_ID + ") REFERENCES " + 
                TABLE_NURSERIES + "(" + COL_NURSERY_ID + "))";
        db.execSQL(createFacilitiesTable);
        
        // إضافة بيانات أولية
        insertInitialData(db);
    }
    
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NURSERIES);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_REVIEWS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BOOKINGS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FACILITIES);
        onCreate(db);
    }
    
    private void insertInitialData(SQLiteDatabase db) {
        // إضافة مستخدم أدمن افتراضي
        ContentValues adminValues = new ContentValues();
        adminValues.put(COL_USER_NAME, "Admin");
        adminValues.put(COL_USER_EMAIL, "admin@nursery.com");
        adminValues.put(COL_USER_PASSWORD, "admin123");
        adminValues.put(COL_USER_PHONE, "+96812345678");
        adminValues.put(COL_USER_TYPE, "admin");
        db.insert(TABLE_USERS, null, adminValues);
        
        // إضافة مستخدم تجريبي
        ContentValues userValues = new ContentValues();
        userValues.put(COL_USER_NAME, "محمد أحمد");
        userValues.put(COL_USER_EMAIL, "user@example.com");
        userValues.put(COL_USER_PASSWORD, "user123");
        userValues.put(COL_USER_PHONE, "+96812345679");
        userValues.put(COL_USER_TYPE, "user");
        db.insert(TABLE_USERS, null, userValues);
    }
    
    // ==================== عمليات المستخدمين ====================
    
    public long addUser(String name, String email, String password, String phone, String type) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_USER_NAME, name);
        values.put(COL_USER_EMAIL, email);
        values.put(COL_USER_PASSWORD, password);
        values.put(COL_USER_PHONE, phone);
        values.put(COL_USER_TYPE, type);
        long id = db.insert(TABLE_USERS, null, values);
        db.close();
        return id;
    }
    
    public boolean checkUserLogin(String email, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_USERS + " WHERE " + 
                       COL_USER_EMAIL + " = ? AND " + COL_USER_PASSWORD + " = ?";
        Cursor cursor = db.rawQuery(query, new String[]{email, password});
        boolean exists = cursor.getCount() > 0;
        cursor.close();
        db.close();
        return exists;
    }
    
    public String getUserType(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT " + COL_USER_TYPE + " FROM " + TABLE_USERS + 
                       " WHERE " + COL_USER_EMAIL + " = ?";
        Cursor cursor = db.rawQuery(query, new String[]{email});
        String type = "user";
        if (cursor.moveToFirst()) {
            type = cursor.getString(0);
        }
        cursor.close();
        db.close();
        return type;
    }
    
    // ==================== عمليات الحضانات ====================
    
    public long addNursery(Nursery nursery) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_NURSERY_NAME, nursery.getName());
        values.put(COL_NURSERY_DESC, nursery.getDescription());
        values.put(COL_NURSERY_ADDRESS, nursery.getAddress());
        values.put(COL_NURSERY_PHONE, nursery.getPhone());
        values.put(COL_NURSERY_EMAIL, nursery.getEmail());
        values.put(COL_NURSERY_LAT, nursery.getLatitude());
        values.put(COL_NURSERY_LNG, nursery.getLongitude());
        values.put(COL_NURSERY_RATING, nursery.getRating());
        values.put(COL_NURSERY_REVIEW_COUNT, nursery.getReviewCount());
        values.put(COL_NURSERY_PRICE, nursery.getPricePerMonth());
        values.put(COL_NURSERY_AGE_RANGE, nursery.getAgeRange());
        values.put(COL_NURSERY_HOURS, nursery.getOpeningHours());
        values.put(COL_NURSERY_DISTANCE, nursery.getDistance());
        values.put(COL_NURSERY_IMAGE, nursery.getImageUrl());
        values.put(COL_NURSERY_VERIFIED, nursery.isVerified() ? 1 : 0);
        values.put(COL_NURSERY_CAPACITY, nursery.getCapacity());
        values.put(COL_NURSERY_SLOTS, nursery.getAvailableSlots());
        
        long id = db.insert(TABLE_NURSERIES, null, values);
        
        // إضافة المرافق
        if (nursery.getFacilities() != null) {
            for (String facility : nursery.getFacilities()) {
                addFacility((int) id, facility);
            }
        }
        
        db.close();
        return id;
    }
    
    public List<Nursery> getAllNurseries() {
        List<Nursery> nurseries = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NURSERIES, null);
        
        if (cursor.moveToFirst()) {
            do {
                Nursery nursery = new Nursery();
                nursery.setId(cursor.getInt(cursor.getColumnIndexOrThrow(COL_NURSERY_ID)));
                nursery.setName(cursor.getString(cursor.getColumnIndexOrThrow(COL_NURSERY_NAME)));
                nursery.setDescription(cursor.getString(cursor.getColumnIndexOrThrow(COL_NURSERY_DESC)));
                nursery.setAddress(cursor.getString(cursor.getColumnIndexOrThrow(COL_NURSERY_ADDRESS)));
                nursery.setPhone(cursor.getString(cursor.getColumnIndexOrThrow(COL_NURSERY_PHONE)));
                nursery.setEmail(cursor.getString(cursor.getColumnIndexOrThrow(COL_NURSERY_EMAIL)));
                nursery.setLatitude(cursor.getDouble(cursor.getColumnIndexOrThrow(COL_NURSERY_LAT)));
                nursery.setLongitude(cursor.getDouble(cursor.getColumnIndexOrThrow(COL_NURSERY_LNG)));
                nursery.setRating(cursor.getFloat(cursor.getColumnIndexOrThrow(COL_NURSERY_RATING)));
                nursery.setReviewCount(cursor.getInt(cursor.getColumnIndexOrThrow(COL_NURSERY_REVIEW_COUNT)));
                nursery.setPricePerMonth(cursor.getDouble(cursor.getColumnIndexOrThrow(COL_NURSERY_PRICE)));
                nursery.setAgeRange(cursor.getString(cursor.getColumnIndexOrThrow(COL_NURSERY_AGE_RANGE)));
                nursery.setOpeningHours(cursor.getString(cursor.getColumnIndexOrThrow(COL_NURSERY_HOURS)));
                nursery.setDistance(cursor.getDouble(cursor.getColumnIndexOrThrow(COL_NURSERY_DISTANCE)));
                nursery.setImageUrl(cursor.getString(cursor.getColumnIndexOrThrow(COL_NURSERY_IMAGE)));
                nursery.setVerified(cursor.getInt(cursor.getColumnIndexOrThrow(COL_NURSERY_VERIFIED)) == 1);
                nursery.setCapacity(cursor.getInt(cursor.getColumnIndexOrThrow(COL_NURSERY_CAPACITY)));
                nursery.setAvailableSlots(cursor.getInt(cursor.getColumnIndexOrThrow(COL_NURSERY_SLOTS)));
                
                // جلب المرافق
                nursery.setFacilities(getFacilitiesForNursery(nursery.getId()));
                
                // جلب التقييمات
                nursery.setReviews(getReviewsForNursery(nursery.getId()));
                
                nurseries.add(nursery);
            } while (cursor.moveToNext());
        }
        
        cursor.close();
        db.close();
        return nurseries;
    }
    
    public int updateNursery(Nursery nursery) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_NURSERY_NAME, nursery.getName());
        values.put(COL_NURSERY_DESC, nursery.getDescription());
        values.put(COL_NURSERY_ADDRESS, nursery.getAddress());
        values.put(COL_NURSERY_PHONE, nursery.getPhone());
        values.put(COL_NURSERY_EMAIL, nursery.getEmail());
        values.put(COL_NURSERY_PRICE, nursery.getPricePerMonth());
        values.put(COL_NURSERY_AGE_RANGE, nursery.getAgeRange());
        values.put(COL_NURSERY_HOURS, nursery.getOpeningHours());
        values.put(COL_NURSERY_CAPACITY, nursery.getCapacity());
        values.put(COL_NURSERY_SLOTS, nursery.getAvailableSlots());
        
        int rows = db.update(TABLE_NURSERIES, values, COL_NURSERY_ID + " = ?", 
                            new String[]{String.valueOf(nursery.getId())});
        db.close();
        return rows;
    }
    
    public void deleteNursery(int nurseryId) {
        SQLiteDatabase db = this.getWritableDatabase();
        // حذف المرافق المرتبطة
        db.delete(TABLE_FACILITIES, COL_FACILITY_NURSERY_ID + " = ?", 
                 new String[]{String.valueOf(nurseryId)});
        // حذف التقييمات المرتبطة
        db.delete(TABLE_REVIEWS, COL_REVIEW_NURSERY_ID + " = ?", 
                 new String[]{String.valueOf(nurseryId)});
        // حذف الحضانة
        db.delete(TABLE_NURSERIES, COL_NURSERY_ID + " = ?", 
                 new String[]{String.valueOf(nurseryId)});
        db.close();
    }
    
    // ==================== عمليات المرافق ====================
    
    public long addFacility(int nurseryId, String facilityName) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_FACILITY_NURSERY_ID, nurseryId);
        values.put(COL_FACILITY_NAME, facilityName);
        long id = db.insert(TABLE_FACILITIES, null, values);
        db.close();
        return id;
    }
    
    public List<String> getFacilitiesForNursery(int nurseryId) {
        List<String> facilities = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT " + COL_FACILITY_NAME + " FROM " + TABLE_FACILITIES + 
                       " WHERE " + COL_FACILITY_NURSERY_ID + " = ?";
        Cursor cursor = db.rawQuery(query, new String[]{String.valueOf(nurseryId)});
        
        if (cursor.moveToFirst()) {
            do {
                facilities.add(cursor.getString(0));
            } while (cursor.moveToNext());
        }
        
        cursor.close();
        db.close();
        return facilities;
    }
    
    // ==================== عمليات التقييمات ====================
    
    public long addReview(Review review) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_REVIEW_NURSERY_ID, review.getNurseryId());
        values.put(COL_REVIEW_USER_NAME, review.getUserName());
        values.put(COL_REVIEW_RATING, review.getRating());
        values.put(COL_REVIEW_COMMENT, review.getComment());
        values.put(COL_REVIEW_DATE, review.getDate());
        values.put(COL_REVIEW_VERIFIED, review.isVerified() ? 1 : 0);
        long id = db.insert(TABLE_REVIEWS, null, values);
        db.close();
        return id;
    }
    
    public List<Review> getReviewsForNursery(int nurseryId) {
        List<Review> reviews = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_REVIEWS + " WHERE " + 
                       COL_REVIEW_NURSERY_ID + " = ?";
        Cursor cursor = db.rawQuery(query, new String[]{String.valueOf(nurseryId)});
        
        if (cursor.moveToFirst()) {
            do {
                Review review = new Review(
                    cursor.getInt(cursor.getColumnIndexOrThrow(COL_REVIEW_ID)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(COL_REVIEW_NURSERY_ID)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COL_REVIEW_USER_NAME)),
                    cursor.getFloat(cursor.getColumnIndexOrThrow(COL_REVIEW_RATING)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COL_REVIEW_COMMENT)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COL_REVIEW_DATE))
                );
                review.setVerified(cursor.getInt(cursor.getColumnIndexOrThrow(COL_REVIEW_VERIFIED)) == 1);
                reviews.add(review);
            } while (cursor.moveToNext());
        }
        
        cursor.close();
        db.close();
        return reviews;
    }
    
    public List<Review> getAllReviews() {
        List<Review> reviews = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_REVIEWS, null);
        
        if (cursor.moveToFirst()) {
            do {
                Review review = new Review(
                    cursor.getInt(cursor.getColumnIndexOrThrow(COL_REVIEW_ID)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(COL_REVIEW_NURSERY_ID)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COL_REVIEW_USER_NAME)),
                    cursor.getFloat(cursor.getColumnIndexOrThrow(COL_REVIEW_RATING)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COL_REVIEW_COMMENT)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COL_REVIEW_DATE))
                );
                reviews.add(review);
            } while (cursor.moveToNext());
        }
        
        cursor.close();
        db.close();
        return reviews;
    }
    
    // ==================== عمليات الحجوزات ====================
    
    public long addBooking(Booking booking) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_BOOKING_NURSERY_ID, booking.getNurseryId());
        values.put(COL_BOOKING_NURSERY_NAME, booking.getNurseryName());
        values.put(COL_BOOKING_CHILD_NAME, booking.getChildName());
        values.put(COL_BOOKING_CHILD_AGE, booking.getChildAge());
        values.put(COL_BOOKING_PARENT_NAME, booking.getParentName());
        values.put(COL_BOOKING_PARENT_PHONE, booking.getParentPhone());
        values.put(COL_BOOKING_PARENT_EMAIL, booking.getParentEmail());
        values.put(COL_BOOKING_START_DATE, booking.getStartDate());
        values.put(COL_BOOKING_PACKAGE_TYPE, booking.getPackageType());
        values.put(COL_BOOKING_NOTES, booking.getAdditionalNotes());
        values.put(COL_BOOKING_DATE, booking.getBookingDate());
        values.put(COL_BOOKING_STATUS, booking.getStatus());
        long id = db.insert(TABLE_BOOKINGS, null, values);
        db.close();
        return id;
    }
    
    public List<Booking> getAllBookings() {
        List<Booking> bookings = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_BOOKINGS, null);
        
        if (cursor.moveToFirst()) {
            do {
                Booking booking = new Booking(
                    cursor.getInt(cursor.getColumnIndexOrThrow(COL_BOOKING_NURSERY_ID)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COL_BOOKING_NURSERY_NAME)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COL_BOOKING_CHILD_NAME)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(COL_BOOKING_CHILD_AGE)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COL_BOOKING_PARENT_NAME)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COL_BOOKING_PARENT_PHONE)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COL_BOOKING_PARENT_EMAIL)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COL_BOOKING_START_DATE)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COL_BOOKING_PACKAGE_TYPE)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COL_BOOKING_NOTES))
                );
                booking.setId(cursor.getInt(cursor.getColumnIndexOrThrow(COL_BOOKING_ID)));
                booking.setBookingDate(cursor.getString(cursor.getColumnIndexOrThrow(COL_BOOKING_DATE)));
                booking.setStatus(cursor.getString(cursor.getColumnIndexOrThrow(COL_BOOKING_STATUS)));
                bookings.add(booking);
            } while (cursor.moveToNext());
        }
        
        cursor.close();
        db.close();
        return bookings;
    }
}

