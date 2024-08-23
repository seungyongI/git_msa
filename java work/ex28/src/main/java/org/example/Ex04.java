package org.example;

import java.util.Arrays;

/*
interface 는 각 몸체가 없는 하나의 메서드만 존재해야 함.
static, defalut 예약어를 사용하면 몸체가 있기에 메서드를 만들 수 있다.
 */
interface AA {
    int doA();

    default void doB() {
        System.out.println("Method doB");
    }

    static void doC() {
        System.out.println("Method doC");
    }
}

public class Ex04 {

    public static void doMethod(AA aa) {
        aa.doA();
        aa.doB();
        AA.doC();
    }

    public static void main(String[] args) {
        AA aa = () -> {
            System.out.println("Method doA Override");
            return 10;
        };

//        AA aa = () -> 10;
        int result = aa.doA();
        System.out.println(result);

//        doMethod(() ->
//            System.out.println("New Method Override")
//        );

//        doMethod(() ->{
//            System.out.println("New Method Override");
//            System.out.println("New Method Override");
//            System.out.println("New Method Override");
//        });
    }

}
