package com.example;

public class Bus implements Vehicle {
    private Fare fare;
     String capacity;

     public Bus() {

     }
    
     public void getMileage() {
         System.out.println("Bus mileage: 8 km/l");
     }
     
     // setter di
     public void setFareObject(Fare fare) {
         this.fare = fare;
     }

     public void getFare() {
         System.out.println("Bus Total fare: " + fare.fareforBus());
     }
    // injecting literal value by seter(property)
    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public void getCapacity() {
        System.out.println("Bus Capacity :" + capacity);
    }
    
    

    
}
