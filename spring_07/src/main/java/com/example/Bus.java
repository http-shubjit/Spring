package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component()
public class Bus implements Vehicle {

    @Value("${busprice}")    private int mrp;

    
    public void getPrice() {
        System.out.println("Bus Price is: "+mrp);
    }
    
}
