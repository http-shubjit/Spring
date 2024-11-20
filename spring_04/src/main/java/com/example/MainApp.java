package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        // Load the Spring context
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Retrieve and use the Car bean
        Vehicle car = (Vehicle) context.getBean("car");
        car.getMileage();
        car.getFare();

        // Retrieve and use the Bus bean
        Vehicle bus = (Vehicle) context.getBean("bus");
        bus.getMileage();
        bus.getFare();
    }
}
