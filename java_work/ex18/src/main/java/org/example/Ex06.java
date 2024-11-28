package org.example;

public class Ex06 {

    public static void main(String[] args) {
        String myDoc = "mydocument";

        Printable prn = new Sprint();
        prn.print(myDoc);

        prn = new Lprint();
        prn.print(myDoc);
    }

}