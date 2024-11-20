package com.example;

public class Car implements Vehicle {

    private Fare fare;
    String capacity;

    public Car() {

    }
    
    public void getMileage() {
        System.out.println("Car mileage: 15 km/l");
    }

    //setter di  setFareObject(Fare fare=new Fare()) generate by the bean
    public void setFareObject(Fare fare) {
        this.fare = fare;
    }

    public void getFare() {
        System.out.println("Car fare: " + fare.fareforCar());
    }
   
    // injecting literal value by seter(property)
    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public void getCapacity() {
       System.out.println("Car Total Capacity :"+capacity);
    }
}
