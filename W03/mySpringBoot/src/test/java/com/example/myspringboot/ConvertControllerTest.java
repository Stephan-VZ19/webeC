package com.example.myspringboot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConvertControllerTest {

    ConvertController controller = new ConvertController();

    @Test
    public void testConvertView() {
        var modelAndView = controller.convert(10);
        assertEquals("convert", modelAndView.getViewName());
    }


}
