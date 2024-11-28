package org.example;

import java.util.stream.Stream;

public class Ex07 {
    public static void main(String[] args) {
        boolean b = Stream.of(1,2,3,4,5,6)
                .allMatch(integer -> integer % 2 == 0);
        System.out.println("true or false? = " + b);
    }
}
