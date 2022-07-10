package com.calendar.manager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DefaultController {

    @GetMapping("/")
    @ResponseBody
    public String health() {
        return "Application OK";
    }
}
