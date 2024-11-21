package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("car")
public class Car implements Vehicle {

    @Value("${carprice}")
        private int mrp;


    public void getPrice() {
        System.out.println("Car Price is: " + mrp);
    }
    
    
}
