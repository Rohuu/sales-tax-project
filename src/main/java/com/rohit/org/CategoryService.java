package com.rohit.org;

import java.util.HashSet;
import java.util.Set;

public class CategoryService {

    Set<String> foods=Set.of("chocolate");
    Set<String> medicines=Set.of("pills");
    Set<String> books=Set.of("book");


    public Category getCategoryByProductName(String productName) {
        if(foods.contains(productName)){
            return Category.FOOD;
        }
         else if(medicines.contains(productName)){
            return Category.MEDICAL;
        }
         else if(books.contains(productName)){
            return Category.BOOK;
        }
        return Category.OTHERS;
    }
}