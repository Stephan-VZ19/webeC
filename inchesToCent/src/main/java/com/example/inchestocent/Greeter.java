package com.example.inchestocent;

import org.springframework.stereotype.Component;

@Component
public class Greeter {

    private final GreetingDestination dest;

    public Greeter(GreetingDestination dest) {
        this.dest = dest;
    }

    public void greet(String name) {
        var greeting = "Hello, " + name + "!";
        dest.write(greeting);
    }

}
