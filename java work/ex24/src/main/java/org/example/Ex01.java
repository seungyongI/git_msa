package org.example;

public class Ex01 {

    public static void main(String[] args) {
        BoxFactory.peekBox4(new Box<AA>(new AA()));
        BoxFactory.peekBox4(new Box<BB>(new BB()));
        BoxFactory.peekBox4(new Box<CC>(new CC()));
        /*
        사용불가
        BoxFactory.peekBox4(new Box<>(new Object()));
         */

        BoxFactory.peekBox5(new Box<AA>(new AA()));
        BoxFactory.peekBox5(new Box<BB>(new BB()));

        /*
        이거는 안 됨
        BoxFactory.peekBox5(new Box<CC>(new CC()));
         */

    }
}
