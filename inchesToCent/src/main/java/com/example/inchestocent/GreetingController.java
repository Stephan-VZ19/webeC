package com.example.inchestocent;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetingController {

    public final Greeter greeter;

    public GreetingController(Greeter greeter) {
        this.greeter = greeter;
    }

    @GetMapping("/greet")
    public ResponseEntity<String> greet() {
        greeter.greet("Spring Boot");
        return ResponseEntity.ok("Request processed");
    }


}
