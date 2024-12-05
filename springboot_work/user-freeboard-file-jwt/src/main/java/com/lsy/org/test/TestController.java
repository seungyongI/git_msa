package com.lsy.org.test;

//@RestController
//@RequestMapping("test")
//public class TestController {
//
//    private final Environment environment;
//    //    @Value("${spring.jwt.secret}")
//    private final String secretKey;
//    private final JWTManager jwtManager;
//
//    public TestController(Environment environment, JWTManager jwtManager) {
//        this.environment = environment;
//        this.secretKey = environment.getProperty("spring.jwt.secret");
//        this.jwtManager = jwtManager;
//    }
//
//    @GetMapping("makeToken")
//    public String makeToken() {
//        String jwt = jwtManager.createJWT(secretKey);
//        return "makeToken " + jwt;
//    }
//
//    @GetMapping("validToken")
//    public String validToken(@RequestHeader(HttpHeaders.AUTHORIZATION) String authorization) {
//        // jwt 토큰 검증
////        System.out.println("authorization = " + authorization);
//        String result = jwtManager.vaildJWT(authorization.split(" ")[1], secretKey);
//
//        return "validToken " + result;
//    }
//}
