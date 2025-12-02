package com.example.h1.utils;

import android.content.Intent;
import android.net.Uri;
import com.example.h1.models.Booking;

public class EmailNotificationHelper {
    
    public static Intent createBookingConfirmationEmail(Booking booking) {
        String subject = "تأكيد حجز الحضانة - " + booking.getNurseryName();
        String body = buildEmailBody(booking);
        
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:" + booking.getParentEmail()));
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, body);
        
        return intent;
    }
    
    private static String buildEmailBody(Booking booking) {
        StringBuilder body = new StringBuilder();
        body.append("مرحباً ").append(booking.getParentName()).append(",\n\n");
        body.append("شكراً لك على حجزك في ").append(booking.getNurseryName()).append(".\n\n");
        body.append("تفاصيل الحجز:\n");
        body.append("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");
        body.append("اسم الطفل: ").append(booking.getChildName()).append("\n");
        body.append("عمر الطفل: ").append(booking.getChildAge()).append(" سنوات\n");
        body.append("تاريخ البدء: ").append(booking.getStartDate()).append("\n");
        body.append("نوع الباقة: ").append(getPackageTypeArabic(booking.getPackageType())).append("\n");
        
        if (booking.getAdditionalNotes() != null && !booking.getAdditionalNotes().isEmpty()) {
            body.append("ملاحظات: ").append(booking.getAdditionalNotes()).append("\n");
        }
        
        body.append("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n\n");
        body.append("سيتم التواصل معك قريباً من قبل الحضانة لتأكيد الحجز.\n\n");
        body.append("مع تحياتنا،\n");
        body.append("فريق التطبيق");
        
        return body.toString();
    }
    
    private static String getPackageTypeArabic(String packageType) {
        switch (packageType) {
            case "FULL_TIME":
                return "دوام كامل";
            case "PART_TIME":
                return "دوام جزئي";
            case "HOURLY":
                return "بالساعة";
            default:
                return packageType;
        }
    }
    
    public static String createSMSMessage(Booking booking) {
        return "شكراً لك على حجزك في " + booking.getNurseryName() + 
               ". سيتم التواصل معك قريباً لتأكيد الحجز. رقم الحجز: " + booking.getId();
    }
}

