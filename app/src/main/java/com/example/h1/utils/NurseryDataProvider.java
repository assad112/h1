package com.example.h1.utils;

import com.example.h1.models.Nursery;
import com.example.h1.models.Review;

import java.util.ArrayList;
import java.util.List;

public class NurseryDataProvider {
    
    public static List<Nursery> getSampleNurseries() {
        List<Nursery> nurseries = new ArrayList<>();
        
        // Nursery 1
        Nursery nursery1 = new Nursery(
            1,
            "Bright Beginnings Nursery",
            "A warm and nurturing environment where children thrive. Our experienced staff provides personalized care with focus on early childhood development.",
            "123 Main Street, Silkana",
            "+96812345678",
            "info@brightbeginnings.com",
            0.0, 0.0,
            4.8f, 127,
            320.0,
            "0-5 years",
            "Mon-Fri: 7:00 AM - 6:00 PM",
            2.3,
            ""
        );
        nursery1.addFacility("Indoor Playground");
        nursery1.addFacility("CCTV Security");
        nursery1.addFacility("Healthy Meals");
        nursery1.addFacility("Educational Programs");
        nursery1.addFacility("Air Conditioned");
        nursery1.setCapacity(50);
        nursery1.setAvailableSlots(5);
        nursery1.addReview(new Review(1, 1, "Sarah Johnson", 5.0f, "Excellent nursery! My daughter loves going there every day. The staff is professional and caring.", "Nov 2024"));
        nursery1.addReview(new Review(2, 1, "Mike Anderson", 4.5f, "Great facilities and very clean. Staff is friendly and communicative.", "Oct 2024"));
        nurseries.add(nursery1);
        
        // Nursery 2
        Nursery nursery2 = new Nursery(
            2,
            "Little Stars Childcare",
            "Premium childcare facility with state-of-the-art learning environment. We focus on holistic development through play-based learning.",
            "456 Oak Avenue, Silkana",
            "+96812345679",
            "contact@littlestars.com",
            0.0, 0.0,
            4.6f, 89,
            360.0,
            "1-4 years",
            "Mon-Sat: 6:30 AM - 7:00 PM",
            1.8,
            ""
        );
        nursery2.addFacility("Outdoor Garden");
        nursery2.addFacility("Music Classes");
        nursery2.addFacility("Art Activities");
        nursery2.addFacility("Swimming Pool");
        nursery2.addFacility("Qualified Teachers");
        nursery2.setCapacity(40);
        nursery2.setAvailableSlots(8);
        nursery2.addReview(new Review(3, 2, "Emily Davis", 5.0f, "Amazing place! The teachers are wonderful and my son has learned so much.", "Nov 2024"));
        nurseries.add(nursery2);
        
        // Nursery 3
        Nursery nursery3 = new Nursery(
            3,
            "Sunshine Kids Academy",
            "Affordable and quality childcare with experienced educators. We provide a safe, stimulating environment for your little ones.",
            "789 Pine Road, Silkana",
            "+96812345680",
            "hello@sunshinekids.com",
            0.0, 0.0,
            4.5f, 156,
            250.0,
            "0-3 years",
            "Mon-Fri: 7:30 AM - 5:30 PM",
            3.5,
            ""
        );
        nursery3.addFacility("Safe Environment");
        nursery3.addFacility("Daily Activities");
        nursery3.addFacility("Nutritious Meals");
        nursery3.addFacility("Parent Communication App");
        nursery3.setCapacity(35);
        nursery3.setAvailableSlots(12);
        nursery3.addReview(new Review(4, 3, "Jessica Brown", 4.0f, "Good value for money. Staff is caring and facilities are adequate.", "Oct 2024"));
        nurseries.add(nursery3);
        
        // Nursery 4
        Nursery nursery4 = new Nursery(
            4,
            "Rainbow Montessori Center",
            "Montessori-based education center focusing on independent learning and creativity. Our curriculum promotes natural development.",
            "321 Elm Street, Silkana",
            "+96812345681",
            "info@rainbowmontessori.com",
            0.0, 0.0,
            4.9f, 203,
            420.0,
            "2-6 years",
            "Mon-Fri: 8:00 AM - 4:00 PM",
            1.2,
            ""
        );
        nursery4.addFacility("Montessori Materials");
        nursery4.addFacility("Bilingual Program");
        nursery4.addFacility("Nature Exploration");
        nursery4.addFacility("Small Class Sizes");
        nursery4.addFacility("Certified Montessori Teachers");
        nursery4.setCapacity(30);
        nursery4.setAvailableSlots(3);
        nursery4.addReview(new Review(5, 4, "David Wilson", 5.0f, "Outstanding Montessori program! Worth every penny. Highly recommend!", "Nov 2024"));
        nursery4.addReview(new Review(6, 4, "Lisa Martinez", 4.8f, "My twins have flourished here. The teachers are exceptional.", "Oct 2024"));
        nurseries.add(nursery4);
        
        // Nursery 5
        Nursery nursery5 = new Nursery(
            5,
            "Happy Hearts Daycare",
            "Family-oriented daycare providing loving care in a home-like setting. We treat every child as part of our family.",
            "654 Maple Drive, Silkana",
            "+96812345682",
            "care@happyhearts.com",
            0.0, 0.0,
            4.4f, 72,
            290.0,
            "0-4 years",
            "Mon-Sat: 7:00 AM - 6:00 PM",
            2.8,
            ""
        );
        nursery5.addFacility("Home-like Environment");
        nursery5.addFacility("Flexible Hours");
        nursery5.addFacility("Organic Meals");
        nursery5.addFacility("Daily Reports");
        nursery5.setCapacity(25);
        nursery5.setAvailableSlots(7);
        nursery5.addReview(new Review(7, 5, "Amanda Taylor", 4.5f, "Warm and welcoming environment. My baby is always happy here.", "Nov 2024"));
        nurseries.add(nursery5);
        
        // Nursery 6
        Nursery nursery6 = new Nursery(
            6,
            "Growing Minds Preschool",
            "Comprehensive preschool program preparing children for kindergarten. We emphasize social skills and academic readiness.",
            "987 Cedar Lane, Silkana",
            "+96812345683",
            "admin@growingminds.com",
            0.0, 0.0,
            4.7f, 145,
            340.0,
            "2-5 years",
            "Mon-Fri: 8:00 AM - 3:00 PM",
            4.1,
            ""
        );
        nursery6.addFacility("Kindergarten Prep");
        nursery6.addFacility("Computer Lab");
        nursery6.addFacility("Library");
        nursery6.addFacility("Sports Activities");
        nursery6.addFacility("After School Care");
        nursery6.setCapacity(45);
        nursery6.setAvailableSlots(10);
        nursery6.addReview(new Review(8, 6, "Robert Garcia", 4.7f, "Excellent preparation for school. My daughter is reading already!", "Oct 2024"));
        nurseries.add(nursery6);
        
        // Nursery 7
        Nursery nursery7 = new Nursery(
            7,
            "Tiny Tots Learning Center",
            "Modern learning center with cutting-edge facilities and innovative curriculum. We inspire curiosity and love for learning.",
            "147 Birch Boulevard, Silkana",
            "+96812345684",
            "info@tinytots.com",
            0.0, 0.0,
            4.3f, 98,
            300.0,
            "1-5 years",
            "Mon-Sat: 6:00 AM - 7:00 PM",
            3.2,
            ""
        );
        nursery7.addFacility("Smart Classrooms");
        nursery7.addFacility("STEM Activities");
        nursery7.addFacility("Dance Classes");
        nursery7.addFacility("Parent Portal");
        nursery7.setCapacity(55);
        nursery7.setAvailableSlots(15);
        nursery7.addReview(new Review(9, 7, "Jennifer Lee", 4.0f, "Good facilities and programs. My son enjoys the STEM activities.", "Nov 2024"));
        nurseries.add(nursery7);
        
        // Nursery 8
        Nursery nursery8 = new Nursery(
            8,
            "Precious Angels Nursery",
            "Boutique nursery offering personalized attention to each child. Low teacher-to-child ratio ensures individual care.",
            "258 Willow Way, Silkana",
            "+96812345685",
            "angels@precious.com",
            0.0, 0.0,
            4.8f, 64,
            400.0,
            "0-3 years",
            "Mon-Fri: 7:00 AM - 5:00 PM",
            1.5,
            ""
        );
        nursery8.addFacility("Low Ratio Care");
        nursery8.addFacility("Infant Care Specialists");
        nursery8.addFacility("Sleep Training");
        nursery8.addFacility("Breast Milk Storage");
        nursery8.addFacility("Parent Workshops");
        nursery8.setCapacity(20);
        nursery8.setAvailableSlots(2);
        nursery8.addReview(new Review(10, 8, "Michelle White", 5.0f, "Perfect for infants! The care is exceptional and staff is highly trained.", "Nov 2024"));
        nurseries.add(nursery8);
        
        return nurseries;
    }
}

