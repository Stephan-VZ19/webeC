package com.example.inchestocent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InchesToCentApplication {

    public static void main(String[] args) {

        var context = SpringApplication.run(InchesToCentApplication.class, args);

        var greeter = context.getBean(Greeter.class);
        greeter.greet("Spring Boot");

    }

}
