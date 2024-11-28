package com.green.userservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "first-service", url = "${first-service-url}")
public interface FirstClient {

//    http://first-service/first-service/test
    @GetMapping("/first-service/test")
    String getTest();

}