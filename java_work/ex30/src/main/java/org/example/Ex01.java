package org.example;

import java.util.Arrays;

public class Ex01 {
    public static void main(String[] args) {
        String[] arr = {"YOON", "PARK", "ROBOT"};

        for (String temp : arr) {
            System.out.println("Content = " + temp);
        }

        /*
        1. Stream 생성 방법
        2. 중간연산 filter, map
        3. 최종연산 sum, foreach
            최종연산은 한 번에 하나만 사용 가능
         */

        Arrays.stream(arr)
                .forEach(s -> System.out.println("Content = " + s));

    }
}
