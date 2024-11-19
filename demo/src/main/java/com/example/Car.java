package com.example;

public class Car implements Vehicle {
    @Override
    public void getMileage() {
        System.out.println("Car mileage: 15 km/l");
    }
}
