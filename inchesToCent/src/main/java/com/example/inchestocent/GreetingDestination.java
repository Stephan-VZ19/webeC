package com.example.inchestocent;

import org.springframework.stereotype.Component;

@Component
public class GreetingDestination {
    public void write(String greeting) {
        System.out.println(greeting);
    }
}
