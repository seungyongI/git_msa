package org.example.service;

import org.example.repository.MovieDB;

import java.util.Scanner;

public class DBMain {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        MovieDB movieDB = new MovieDB();

        while (true) {
            System.out.println("""
                    1. 입력
                    2. 조회
                    3. 수정
                    4. 삭제
                    0. 종료
                    """);
            int cho = scan.nextInt();
            if (cho == 1) {
                movieDB.insert();
            } else if (cho == 2) {
                movieDB.select();
            } else {
                break;
            }
        }
    }
}