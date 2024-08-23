package org.example;

import com.google.protobuf.TextFormat;

interface Printable{
    void print();
}

class Papers{
    private String con;

    public Papers(String con) {
        this.con = con;
    }
    /*
    로컬 클래스

    public Printable getPrint(){
        class Printer implements Printable {
            @Override
            public void print() {
                System.out.println(con);
            }
        }
        return new Printer();
    }
     */
    // 익명클래스
    public Printable getPrint(){
        return new Printable() {
            @Override
            public void print() {
                System.out.println(con);
            }
        };
    }
}

public class Ex02 {

    public static void main(String[] args) {
        Papers papers = new Papers("print something");
        Printable print = papers.getPrint();
        print.print();
    }
}
