package org.example;

import java.util.Arrays;

public class Ex01 {

    //메서드 오버로딩 기법 - 함수 이름이 같더라도 파라미터가 다르면 다른 함수이다.
    public static void doA(int temp) {
        temp += 5;
        System.out.println("do A temp = " + temp);
    }

    public static void doA(int[] crr) {
        for (int i = 0; i < crr.length; i++) {
            crr[i] += 5;
        }
        System.out.println("do A crr = " + Arrays.toString(crr));
    }

    public static void main(String[] args) {
        int a = 10;
        doA(a);
        System.out.println(a);

        int[] arr = {1, 2, 3};
        doA(arr);
        System.out.println(Arrays.toString(arr));
    }
}
