package com.example.myspringboot;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ConvertController {

    @GetMapping("/convert")
    public ResponseEntity<String> convert(double inches) {
        var cm = inches * 2.54;
        var cmPart = (int) cm;
        var mmPart = (int) cm * 10 % 10;
        var response = inches + " inches is: " + cmPart + " cm, " + mmPart + " mm.";
        return ResponseEntity.ok(response);
    }
}
