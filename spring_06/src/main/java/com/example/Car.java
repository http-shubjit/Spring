package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("car")
public class Car implements Vehicle {
    //Using Field Based Injection
    // @Autowired
    private Fare fare;

    // using Constructor Bassed Injection
    // @Autowired 
    // public Car(Fare fare) {
    //     this.fare = fare;
    // }

    //Using Setter Injection
    @Autowired
    public void setFare(Fare fare) {
        this.fare = fare;
    }
     
    
    // Festival Have 2 implementaion class so if i write only Autowired hen spring
    // will confuse which class object instance will assign to the festival
    // reference thats why we use qualifier

    @Autowired
    @Qualifier("fareDiscount")
    private Festival farediscount;

    @Autowired
    @Qualifier("foodDiscount")
    private Festival fooddiscount;


    public void getMileage() {
        System.out.println("Car mileage: 15 km/l");
    }

    public void getFare() {
        System.out.println("Car fare: " + fare.fareforCar());
    }
}