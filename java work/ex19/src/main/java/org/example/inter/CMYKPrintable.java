package org.example.inter;

/*
클래스 간 상속과 인터페이스 간 상속 시 extends 사용
 */

public interface CMYKPrintable extends Printable{
    void printCMYK(String mydoc);
}
