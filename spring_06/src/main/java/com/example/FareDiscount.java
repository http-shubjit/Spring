package com.example;

import org.springframework.stereotype.Component;

@Component("fareDiscount")
public class FareDiscount implements Festival {

    @Override
    public void getDiscount() {
       System.out.println("70% discount on fare");
    }
    
}
