package org.example;

public class Ex01 {

    public static void main(String[] args) {

        /*
        primitive 함수가 없음
         */
        int a = 10;
        /*
         wrapper 클래스 이기 때문에 함수가 존재
         */
        Integer b = Integer.valueOf(20);
        /*unboxing 래퍼클래스가 기본자료형 타입으로 자동 변환
         */
        a = b;

        System.out.println(a);
        System.out.println(b);


    }
}
