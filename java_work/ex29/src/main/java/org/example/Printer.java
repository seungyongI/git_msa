package org.example;

interface Printable{
    void print();
}

public class Printer {
    public static void main(String[] args) {
        /*
        1. class 상속 받아서 하는 방법
        2. 익명 interface
        3. lamda
         */

        Printable print = new Printable() {
            @Override
            public void print() {
                System.out.println("Anonymous interface");
            }
        };

        Printable printLamda = () -> System.out.println("Lamda");
        printLamda.print();
    }
}
