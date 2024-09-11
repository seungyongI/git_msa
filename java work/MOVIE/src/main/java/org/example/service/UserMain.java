package org.example.service;

import org.example.repository.MovieActorRepository;
import org.example.repository.MovieDirectorRepository;
import org.example.repository.MovieRepository;

import java.util.Scanner;

public class UserMain {
    public UserMain() {
        MovieRepository movieRepository = new MovieRepository();
        MovieDirectorRepository movieDirectorRepository = new MovieDirectorRepository();
        MovieActorRepository movieActorRepository = new MovieActorRepository();
        Scanner scan = new Scanner(System.in);

        System.out.print("영화 조회 서비스 목요명회입니다.\n");
        System.out.print("""
                 💗💗⠀ ⠀ 💗💗
                💗🍬🍬💗🍬🍬💗
                💗🍬🍬🏠🍬🍬💗
                💗 SWEET MYMH 💗
                ⠀ 💗🍬🍬🍬💗
                ⠀ ⠀ 💗🍬💗
                ⠀ ⠀ ⠀ ⠀💗
                """);

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
                movieActorRepository.select();
            } else if (cho == 2) {
                movieDirectorRepository.select();
            } else if (cho == 3) {
                movieRepository.select();
            } else if (cho == 0) {
                System.out.println("이용해 주셔서 감사합니다.");
                break;
            }
        }
    }

    public static void main(String[] args) {
        new UserMain();
    }
}
