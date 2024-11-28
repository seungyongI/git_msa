package org.example.inter;

public interface Printable {

    //static final 변수는 대문자로 짓는 게 관례(interface 에서 생략 가능)
    public static final int HEIGHT = 70;
    int WIDTH = 120;

    //함수는 public이 생략 되어있고 몸체({})를 가질 수 없다.

    void print(String mydoc);

    //default, static을 사용하면 몸체({})를 가질 수 있고 재정의 안 해도 됨.
    default void clean() {
        System.out.println("청소 기능 추가");
    }
    
    static void printLine(){
        System.out.println("한줄 출력할 때 줄바꿈");
    }
}
