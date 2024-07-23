package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex03 {

    /*
    interface
    변수 public static final 생략 가능
    int A;(final 변수는 대문자로 하는 게 관례)
    몸체가 없는 메서드 public 생략 가능
    void doA();

    class 만들어서 interface 상속 받아야 됨
    doA() 메서드 재정의 해야 됨

    default() static() 추가 가능
    메서드 안에 내용 존재 가능

    default() 사용 -> new를 사용해야 하는 것
    static() 사용 -> Printable.doA();

    람다 규칙은
    interface '하나의' 추상메서드가 존재 해야한다.
    () -> {}

    docker desktop
    database
    MYSQL server 설치

    가상 OS
    docker run 명령어 설치
    
    heidisql client
    
    Java 접속 :
   
    18장
    try{} catch{} 예외상황에 대해서 학습
    
     */

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        try {
            System.out.print("a : ");
            int a = scan.nextInt();
            System.out.print("b : ");
            int b = scan.nextInt();

            System.out.println("나누기 시작");
            System.out.println("몫 : " + a / b);
            System.out.println("나누기 끝");

            int[] c = new int[3];
            System.out.println(c[4]);

        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
//            e.printStackTrace();
            System.out.println("0으로 나눌 수 없습니다.");
        } catch (InputMismatchException ie) {
            System.out.println("문자는 넣을 수 없습니다.");
        }
        catch (Exception p) {
            System.out.println("이것은 모든 예외 상황"+"\n"+p.getMessage());
        }
        System.out.println("정상 종료 되었습니다.");
    }
}
