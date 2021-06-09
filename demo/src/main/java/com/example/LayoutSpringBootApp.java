package com.example;

import com.example.rest.LayoutController;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LayoutSpringBootApp {
    public static void main(String[] args) {
        LayoutController controller;
        //controller.solve();
        SpringApplication.run(LayoutSpringBootApp.class, args);
    }
}
