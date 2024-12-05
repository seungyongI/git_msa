package com.lsy.org;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

//@SpringBootTest
class FirstApplicationTests {

    @Test
    void contextLoads() {

        String[] str = {"10입니다.", "20입니다.", "30입니다."};

        Arrays.stream(str)
                .forEach(System.out::println);

        String result = Arrays.stream(str).reduce("", (s, s2) -> s + s2 );
        System.out.println("result = " + result);
    }

}