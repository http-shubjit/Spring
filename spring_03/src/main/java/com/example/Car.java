package com.example;

public class Car implements Vehicle {

    private Fare fare;

    public Car() {

    }
    //setter di  setFareObject(Fare fare=new Fare()) generate by the bean
    public void setFareObject(Fare fare) {
        this.fare = fare;
    }
    public void getMileage() {
        System.out.println("Car mileage: 15 km/l");
    }

    public void getFare() {
      System.out.println("Car fare: "+fare.fareforCar());
    }
}
