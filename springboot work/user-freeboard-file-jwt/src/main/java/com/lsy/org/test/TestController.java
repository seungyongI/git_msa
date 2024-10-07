package com.lsy.org.test;

import com.lsy.org.JWT.JWTManager;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {

    private final Environment environment;
    //    @Value("${spring.jwt.secret}")
    private final String secretKey;
    private final JWTManager jwtManager;

    public TestController(Environment environment, JWTManager jwtManager) {
        this.environment = environment;
        this.secretKey = environment.getProperty("spring.jwt.secret");
        this.jwtManager = jwtManager;
    }

    @GetMapping("makeToken")
    public String makeToken() {
        String jwt = jwtManager.createJWT(secretKey);
        return "makeToken " + jwt;
    }

    @GetMapping("validToken")
    public String validToken(@RequestHeader(HttpHeaders.AUTHORIZATION) String authorization) {
        // jwt 토큰 검증
//        System.out.println("authorization = " + authorization);
        String result = jwtManager.vaildJWT(authorization.split(" ")[1], secretKey);

        return "validToken " + result;
    }
}
