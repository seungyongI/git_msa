package org.example;


import org.example.inter.Printable;
import org.example.print.LGPrinter;
import org.example.print.SamPrinter;

public class Main {

    public static void main(String[] args) {
        System.out.println(Printable.HEIGHT);
        System.out.println(Printable.WIDTH);

        Printable prn = new LGPrinter();
        prn.print("내 문서");
        
        prn = new SamPrinter();
        prn.print("새 문서");
        

        /*
        static 예약이 붙어 있어서 바로 호출 가능
        final 예약이 붙어 있어서 값 변경 불가
        Printable.HEIGHT = 90;
         */
    }
}