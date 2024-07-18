package org.example;

import org.example.aa.BizMan;
import org.example.aa.Man;

public class Ex03 {

    public static void main(String[] args) {
        BizMan bm = new BizMan("이승용","그린컴퓨터학원","학생");
        Man man = new Man("이승용");
        bm.showInfo();
        System.out.println();
        man.tellInfo();

    }
}
