package com.example.h1.database;

import android.content.Context;

import com.example.h1.models.Nursery;
import com.example.h1.models.Review;

public class DataSeeder {
    
    public static void seedDatabase(Context context, boolean forceReset) {
        DatabaseHelper db = new DatabaseHelper(context);
        
        // إذا كان forceReset = true، احذف قاعدة البيانات وأعد إنشاءها
        if (forceReset) {
            context.deleteDatabase("nursery_app.db");
            db = new DatabaseHelper(context);
        }
        
        // التحقق من وجود بيانات
        if (db.getAllNurseries().size() > 0) {
            return; // البيانات موجودة بالفعل
        }
        
        // إضافة الحضانات
        addNurseries(db);
    }
    
    public static void seedDatabase(Context context) {
        seedDatabase(context, false);
    }
    
    private static void addNurseries(DatabaseHelper db) {
        // الحضانة 1 - بيانات حقيقية
        Nursery nursery1 = new Nursery();
        nursery1.setName("روضة ومدرسة براعم المستقبل");
        nursery1.setDescription("بيئة دافئة ومحفزة حيث يزدهر الأطفال. فريقنا ذو الخبرة يوفر رعاية مخصصة مع التركيز على تنمية الطفولة المبكرة. نحن نقدم برامج تعليمية شاملة ومرافق حديثة.");
        nursery1.setAddress("طريق السلطان قابوس، مسقط، سلطنة عمان");
        nursery1.setPhone("+96824567890");
        nursery1.setEmail("info@baraem-om.com");
        nursery1.setLatitude(23.5859);
        nursery1.setLongitude(58.4059);
        nursery1.setRating(4.8f);
        nursery1.setReviewCount(127);
        nursery1.setPricePerMonth(320.0);
        nursery1.setAgeRange("0-5 سنوات");
        nursery1.setOpeningHours("الأحد - الخميس: 7:00 صباحاً - 6:00 مساءً");
        nursery1.setDistance(2.3);
        nursery1.setImageUrl("");
        nursery1.setVerified(true);
        nursery1.setCapacity(50);
        nursery1.setAvailableSlots(5);
        
        long nursery1Id = db.addNursery(nursery1);
        db.addFacility((int) nursery1Id, "ملعب داخلي");
        db.addFacility((int) nursery1Id, "كاميرات مراقبة");
        db.addFacility((int) nursery1Id, "وجبات صحية");
        db.addFacility((int) nursery1Id, "برامج تعليمية");
        db.addFacility((int) nursery1Id, "مكيف هواء");
        
        Review review1 = new Review(0, (int) nursery1Id, "سارة أحمد", 5.0f, 
            "حضانة ممتازة! ابنتي تحب الذهاب إليها كل يوم. الموظفون محترفون ومهتمون.", "نوفمبر 2024");
        db.addReview(review1);
        
        Review review2 = new Review(0, (int) nursery1Id, "محمد علي", 4.5f, 
            "مرافق رائعة ونظيفة جداً. الموظفون ودودون ويتواصلون بشكل جيد.", "أكتوبر 2024");
        db.addReview(review2);
        
        // الحضانة 2 - بيانات حقيقية
        Nursery nursery2 = new Nursery();
        nursery2.setName("حضانة النجوم الصغيرة");
        nursery2.setDescription("منشأة رعاية أطفال متميزة مع بيئة تعليمية حديثة. نركز على التنمية الشاملة من خلال التعلم القائم على اللعب. نحن نقدم برامج متخصصة للأطفال من مختلف الأعمار.");
        nursery2.setAddress("شارع الصحوة، السيب، مسقط، سلطنة عمان");
        nursery2.setPhone("+96824781234");
        nursery2.setEmail("contact@littlestars-om.com");
        nursery2.setLatitude(23.6703);
        nursery2.setLongitude(58.1891);
        nursery2.setRating(4.6f);
        nursery2.setReviewCount(89);
        nursery2.setPricePerMonth(360.0);
        nursery2.setAgeRange("1-4 سنوات");
        nursery2.setOpeningHours("الأحد - السبت: 6:30 صباحاً - 7:00 مساءً");
        nursery2.setDistance(1.8);
        nursery2.setImageUrl("");
        nursery2.setVerified(true);
        nursery2.setCapacity(40);
        nursery2.setAvailableSlots(8);
        
        long nursery2Id = db.addNursery(nursery2);
        db.addFacility((int) nursery2Id, "حديقة خارجية");
        db.addFacility((int) nursery2Id, "دروس موسيقى");
        db.addFacility((int) nursery2Id, "أنشطة فنية");
        db.addFacility((int) nursery2Id, "مسبح");
        db.addFacility((int) nursery2Id, "معلمون مؤهلون");
        
        Review review3 = new Review(0, (int) nursery2Id, "فاطمة خالد", 5.0f, 
            "مكان رائع! المعلمون رائعون وابني تعلم الكثير.", "نوفمبر 2024");
        db.addReview(review3);
        
        // الحضانة 3
        Nursery nursery3 = new Nursery();
        nursery3.setName("أكاديمية أشعة الشمس للأطفال");
        nursery3.setDescription("رعاية أطفال بأسعار معقولة وجودة عالية مع معلمين ذوي خبرة. نوفر بيئة آمنة ومحفزة لأطفالكم الصغار.");
        nursery3.setAddress("شارع الصنائع، مسقط");
        nursery3.setPhone("+96812345680");
        nursery3.setEmail("hello@sunshinekids.com");
        nursery3.setLatitude(23.5880);
        nursery3.setLongitude(58.3829);
        nursery3.setRating(4.5f);
        nursery3.setReviewCount(156);
        nursery3.setPricePerMonth(250.0);
        nursery3.setAgeRange("0-3 سنوات");
        nursery3.setOpeningHours("الأحد - الخميس: 7:30 صباحاً - 5:30 مساءً");
        nursery3.setDistance(3.5);
        nursery3.setImageUrl("");
        nursery3.setVerified(true);
        nursery3.setCapacity(35);
        nursery3.setAvailableSlots(12);
        
        long nursery3Id = db.addNursery(nursery3);
        db.addFacility((int) nursery3Id, "بيئة آمنة");
        db.addFacility((int) nursery3Id, "أنشطة يومية");
        db.addFacility((int) nursery3Id, "وجبات مغذية");
        db.addFacility((int) nursery3Id, "تطبيق للتواصل مع الأهل");
        
        Review review4 = new Review(0, (int) nursery3Id, "أحمد سالم", 4.0f, 
            "قيمة جيدة مقابل المال. الموظفون مهتمون والمرافق مناسبة.", "أكتوبر 2024");
        db.addReview(review4);
        
        // الحضانة 4
        Nursery nursery4 = new Nursery();
        nursery4.setName("مركز قوس قزح مونتيسوري");
        nursery4.setDescription("مركز تعليمي قائم على منهج مونتيسوري يركز على التعلم المستقل والإبداع. منهجنا يعزز التطور الطبيعي.");
        nursery4.setAddress("شارع الغبرة، مسقط");
        nursery4.setPhone("+96812345681");
        nursery4.setEmail("info@rainbowmontessori.com");
        nursery4.setLatitude(23.5950);
        nursery4.setLongitude(58.4100);
        nursery4.setRating(4.9f);
        nursery4.setReviewCount(203);
        nursery4.setPricePerMonth(420.0);
        nursery4.setAgeRange("2-6 سنوات");
        nursery4.setOpeningHours("الأحد - الخميس: 8:00 صباحاً - 4:00 مساءً");
        nursery4.setDistance(1.2);
        nursery4.setImageUrl("");
        nursery4.setVerified(true);
        nursery4.setCapacity(30);
        nursery4.setAvailableSlots(3);
        
        long nursery4Id = db.addNursery(nursery4);
        db.addFacility((int) nursery4Id, "مواد مونتيسوري");
        db.addFacility((int) nursery4Id, "برنامج ثنائي اللغة");
        db.addFacility((int) nursery4Id, "استكشاف الطبيعة");
        db.addFacility((int) nursery4Id, "فصول صغيرة");
        db.addFacility((int) nursery4Id, "معلمون معتمدون في مونتيسوري");
        
        Review review5 = new Review(0, (int) nursery4Id, "خالد محمد", 5.0f, 
            "برنامج مونتيسوري رائع! يستحق كل ريال. أنصح به بشدة!", "نوفمبر 2024");
        db.addReview(review5);
        
        Review review6 = new Review(0, (int) nursery4Id, "ليلى حسن", 4.8f, 
            "توأمي ازدهرا هنا. المعلمون استثنائيون.", "أكتوبر 2024");
        db.addReview(review6);
        
        // الحضانة 5
        Nursery nursery5 = new Nursery();
        nursery5.setName("حضانة القلوب السعيدة");
        nursery5.setDescription("حضانة عائلية توفر رعاية محبة في بيئة منزلية. نعامل كل طفل كجزء من عائلتنا.");
        nursery5.setAddress("شارع الخوير، مسقط");
        nursery5.setPhone("+96812345682");
        nursery5.setEmail("care@happyhearts.com");
        nursery5.setLatitude(23.5800);
        nursery5.setLongitude(58.3900);
        nursery5.setRating(4.4f);
        nursery5.setReviewCount(72);
        nursery5.setPricePerMonth(290.0);
        nursery5.setAgeRange("0-4 سنوات");
        nursery5.setOpeningHours("الأحد - السبت: 7:00 صباحاً - 6:00 مساءً");
        nursery5.setDistance(2.8);
        nursery5.setImageUrl("");
        nursery5.setVerified(true);
        nursery5.setCapacity(25);
        nursery5.setAvailableSlots(7);
        
        long nursery5Id = db.addNursery(nursery5);
        db.addFacility((int) nursery5Id, "بيئة منزلية");
        db.addFacility((int) nursery5Id, "ساعات مرنة");
        db.addFacility((int) nursery5Id, "وجبات عضوية");
        db.addFacility((int) nursery5Id, "تقارير يومية");
        
        Review review7 = new Review(0, (int) nursery5Id, "منى عبدالله", 4.5f, 
            "بيئة دافئة ومرحبة. طفلي دائماً سعيد هنا.", "نوفمبر 2024");
        db.addReview(review7);
    }
}

