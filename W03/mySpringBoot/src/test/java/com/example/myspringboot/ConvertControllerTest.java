package com.example.myspringboot;

import org.junit.jupiter.api.Test;

public class ConvertControllerTest {

    ConvertController controller = new ConvertController();

    @Test
    public void testConvertView() {
        var modelAndView = controller.convert(10);

    }


}
