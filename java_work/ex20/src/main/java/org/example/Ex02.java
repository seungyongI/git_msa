package org.example;

class Board{}
class PBoard extends Board{}

public class Ex02 {

    public static void main(String[] args) {
        //ClassCastException - 부모객체는 자식객체로 형변환 불가
        Board board = new Board();
//        PBoard pBoard = (PBoard) new Board();

        /*
        에러를 미리 알려줌.
        System.out.printl();
         */

        System.out.println("성공");
    }

}
