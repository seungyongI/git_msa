package org.example.service;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("영화 추천 서비스 목요명회입니다.\n");

        while (true) {
            System.out.println("""
                    원하시는 카테고리의 번호를 입력해주세요.
                    1. 배우
                    2. 감독
                    3. 장르
                    0. 종료
                    """);
            int cho = scan.nextInt();
            if (cho == 1) {
                System.out.println("원하시는 배우의 이름을 입력해주세요.");
                break;
            } else if (cho == 2) {
                System.out.println("원하시는 감독의 이름을 입력해주세요.");
                break;
            } else if (cho == 3) {
                System.out.println("원하시는 장르를 입력해주세요.");
                break;
            } else {
                System.out.println("이용해 주셔서 감사합니다.");
                break;
            }
        }

    }
}
