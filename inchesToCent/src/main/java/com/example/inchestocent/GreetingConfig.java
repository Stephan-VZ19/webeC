package com.example.inchestocent;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GreetingConfig {

    @Bean
    public GreetingDestination destination() {
        return new GreetingDestination();
    }

    @Bean
    public Greeter greeter(GreetingDestination dest) {
        return new Greeter(dest);
    }


}
