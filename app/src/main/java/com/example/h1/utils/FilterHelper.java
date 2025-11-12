package com.example.h1.utils;

import com.example.h1.models.Nursery;

import java.util.ArrayList;
import java.util.List;

public class FilterHelper {
    
    public static class FilterCriteria {
        public double minPrice = 0;
        public double maxPrice = 800;
        public float minRating = 0;
        public double maxDistance = 100;
        public String searchQuery = "";
        
        public FilterCriteria() {
        }
    }
    
    public static List<Nursery> filterNurseries(List<Nursery> nurseries, FilterCriteria criteria) {
        List<Nursery> filtered = new ArrayList<>();
        
        for (Nursery nursery : nurseries) {
            // Apply price filter
            if (nursery.getPricePerMonth() < criteria.minPrice || 
                nursery.getPricePerMonth() > criteria.maxPrice) {
                continue;
            }
            
            // Apply rating filter
            if (nursery.getRating() < criteria.minRating) {
                continue;
            }
            
            // Apply distance filter
            if (nursery.getDistance() > criteria.maxDistance) {
                continue;
            }
            
            // Apply search query
            if (!criteria.searchQuery.isEmpty()) {
                String query = criteria.searchQuery.toLowerCase();
                boolean matchesSearch = nursery.getName().toLowerCase().contains(query) ||
                                      nursery.getAddress().toLowerCase().contains(query) ||
                                      nursery.getDescription().toLowerCase().contains(query);
                if (!matchesSearch) {
                    continue;
                }
            }
            
            filtered.add(nursery);
        }
        
        return filtered;
    }
    
    public static List<Nursery> sortByRating(List<Nursery> nurseries) {
        List<Nursery> sorted = new ArrayList<>(nurseries);
        sorted.sort((n1, n2) -> Float.compare(n2.getRating(), n1.getRating()));
        return sorted;
    }
    
    public static List<Nursery> sortByPrice(List<Nursery> nurseries, boolean ascending) {
        List<Nursery> sorted = new ArrayList<>(nurseries);
        if (ascending) {
            sorted.sort((n1, n2) -> Double.compare(n1.getPricePerMonth(), n2.getPricePerMonth()));
        } else {
            sorted.sort((n1, n2) -> Double.compare(n2.getPricePerMonth(), n1.getPricePerMonth()));
        }
        return sorted;
    }
    
    public static List<Nursery> sortByDistance(List<Nursery> nurseries) {
        List<Nursery> sorted = new ArrayList<>(nurseries);
        sorted.sort((n1, n2) -> Double.compare(n1.getDistance(), n2.getDistance()));
        return sorted;
    }
}

