package org.example.service;

import org.example.repository.MovieRepository;

import java.util.Scanner;

public class MovieService {
    public void start() {
        Scanner scan = new Scanner(System.in);
        MovieRepository movieRepository = new MovieRepository();
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
                movieRepository.insert();
            } else if (cho == 2) {
                movieRepository.select();
            } else if (cho == 3) {
                movieRepository.update();
            } else if (cho == 4) {
                movieRepository.delete();
            }
            else if (cho == 0) {
                break;
            }
        }
    }

}
