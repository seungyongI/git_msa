package org.example;

import java.util.Arrays;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 1) {
                sum += arr[i];
            }
        }

        System.out.println(sum);

        // 배열을 스트림으로 변환
        Arrays.stream(arr)
                // 홀수만 걸러서 계산
                .filter(n -> n % 2 == 1)
                // 총합
                .sum();
        System.out.println(sum);
    }
}