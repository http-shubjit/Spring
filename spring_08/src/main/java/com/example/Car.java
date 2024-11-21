package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// @Component
public class Car implements Vechile {

    @Value("${carmrp}")
    private int mrp;

    public void getMileage() {
        System.out.println("20km/ltr");
    }
    
    public void getMrp() {
        System.out.println(mrp);
    }
    
}
