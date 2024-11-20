package com.example;

public class Bus implements Vehicle {
    private Fare fare;

    public Bus() {
        
    }

    // setter di
    public void setFare(Fare fare) {
        this.fare = fare;
}

    public void getMileage() {
        System.out.println("Bus mileage: 8 km/l");
    }

    public void getFare() {
        System.out.println("Bus fare: "+fare.fareforBus());
    }
}
