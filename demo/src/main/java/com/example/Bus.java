package com.example;

public class Bus implements Vehicle {
    @Override
    public void getMileage() {
        System.out.println("Bus mileage: 8 km/l");
    }
}
