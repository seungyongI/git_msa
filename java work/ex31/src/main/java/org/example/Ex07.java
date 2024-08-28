package org.example;

import java.util.Optional;

public class Ex07 {
    public static void main(String[] args) {
        Optional<String> os1 = Optional.of("hello !!");

        // map method flatmap method
        // Optional map method -> Optional auto change
        // Optional flatMap method -> just return
        String str = os1
                .flatMap(s -> Optional.of("변환 되는 건 Optional로 감싸야 함"))
                .orElse("EMPTY");

        System.out.println(str);
    }
}
