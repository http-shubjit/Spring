package com.example;

import org.springframework.stereotype.Component;

@Component("foodDiscount")
public class FoodDiscount implements Festival{


    public void getDiscount() {
        System.out.println("30% Discount on food ");
    }
    
}
