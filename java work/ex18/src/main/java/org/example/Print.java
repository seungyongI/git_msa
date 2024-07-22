package org.example;

public class Print implements Printable{

    @Override
    public void print(String doc) {
        System.out.println("프린트 됨.");
        System.out.println(doc);
    }

    @Override
    public void doA() {

    }

    public static void main(String[] args) {
        String myDoc = "mydocument";
        Printable print = new Print();
        print.print(myDoc);

//        Printable p2 = new Printable(String doc) {
//            @Override
//            public void print() {
//                System.out.println("새로운 프린터");
//            }
//
//            @Override
//            public void doA() {
//
//            }
//        };
//
//        p2.print();

    }

}
