package org.example;

public class Sprint implements Printable{

    @Override
    public void print(String doc) {
        System.out.println("삼성프린터");
        System.out.println(doc);
    }

    @Override
    public void doA() {

    }
}
