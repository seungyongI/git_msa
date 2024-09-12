package org.example.service;

import org.example.repository.MovieActorRepository;
import org.example.repository.MovieDirectorRepository;
import org.example.repository.MovieRepository;

import java.util.Scanner;

public class UserMain {
    public void user() {
        MovieRepository movieRepository = new MovieRepository();
        MovieDirectorRepository movieDirectorRepository = new MovieDirectorRepository();
        MovieActorRepository movieActorRepository = new MovieActorRepository();
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("""
                    원하시는 카테고리의 번호를 입력해주세요.
                    1. 배우
                    2. 감독
                    3. 장르
                    4. 제목
                    0. 로그아웃
                    """);
            int cho = scan.nextInt();
            if (cho == 1) {
                movieActorRepository.select();
            } else if (cho == 2) {
                movieDirectorRepository.select();
            } else if (cho == 3) {
                movieRepository.genreSelect();
            } else if (cho == 4) {
                movieRepository.titleSelect();
            } else if (cho == 0) {
                System.out.println("""
                        이용해 주셔서 감사합니다.
                        로그아웃 합니다.
                        """);
                break;
            } else {
                System.out.println("""
                        없는 선택지입니다.
                        다시 입력해주시기 바랍니다.
                        """);
            }
        }
    }
}
