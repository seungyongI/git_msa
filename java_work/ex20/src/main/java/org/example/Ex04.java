package org.example;

public class Ex04 {

    public static void main(String[] args) {

        /*
        throws 예외전달
        throw 예외생성

        getMessage()는 Throwable이란 java 자체의 상위 클래스라서 상속받아 사용하는 것,
        desc나 code를 출력하고 싶으면 오버라이딩 기법을 사용.
        return String.format(%s %s %s,Errorcode.getMessage(),code, desc)
        */

        try {
            throw new MyException(
                    new ErrorCode("ID를 입력하세요.",
                                     "A101",
                                     "ID는 영어로 입력하셔야 됩니다.")
            );
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }

    }

}
