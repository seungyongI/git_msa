package org.example;

public class Lprint implements Printable{

    @Override
    public void print(String doc) {
        System.out.println("LG 프린터");
        System.out.println(doc);
    }

    @Override
    public void doA() {

    }
}
