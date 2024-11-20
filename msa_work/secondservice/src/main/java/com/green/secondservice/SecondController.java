package com.green.secondservice;

import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("second-service")
public class SecondController {
    private final Environment environment;

    @GetMapping("test")
    public String test() {
        System.out.println(" Server Running here " + environment.getProperty("local.server.port"));
        return "This is SecondService";
    }
}
