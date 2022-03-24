package com.example.myspringboot;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ConvertController {

    @GetMapping("/convert")
    public ResponseEntity<String> convert(int inches) {
        var cm = inches * 2.54;
        var cmPart = (int) cm;
        var mmPart = (int) ((cm * 10) % 10);
        var response = String.format("""
                <!DOCTYPE html>
                <title>Result</title>
                %d inches is: %d cm, %d mm.
                <a href="/">Back</a>
                """, inches, cmPart, mmPart);
        return ResponseEntity.ok(response);
    }
}
