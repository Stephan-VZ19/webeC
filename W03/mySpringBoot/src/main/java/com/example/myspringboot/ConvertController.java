package com.example.myspringboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ConvertController {

    @GetMapping("/convert")
    public ModelAndView convert(int inches, int feet) {
        var cm = inches * 2.54;
        var cmPart = (int) cm;
        var mmPart = (int) ((cm * 10) % 10);

        var cmFeet = feet * 3.28;
        var cmFeetPart = (int) cm;
        var mmFeetPart = (int) ((cm * 10) % 10);

        var result = new ModelAndView("convert");
        result.addObject("inches", inches);
        result.addObject("cmPart", cmPart);
        result.addObject("mmPart", mmPart);
        return result;
    }
}
