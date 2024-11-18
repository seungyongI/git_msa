package com.green.firstservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {

    @GetMapping("test")
    public String test() {
        return "This is FirstService";
    }
}
