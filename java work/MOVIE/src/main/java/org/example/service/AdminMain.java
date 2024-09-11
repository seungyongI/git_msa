package org.example.service;

import org.example.repository.ActorRepository;
import org.example.repository.MovieActorRepository;
import org.example.repository.MovieDirectorRepository;
import org.example.repository.MovieRepository;

import java.util.Scanner;

public class AdminMain {
    public static void main(String[] args) {
        start();
    }

    public static void start() {
        Scanner scan = new Scanner(System.in);
        MovieRepository movieRepository = new MovieRepository();
        ActorRepository actorRepository = new ActorRepository();
        MovieDirectorRepository movieDirectorRepository = new MovieDirectorRepository();
        MovieActorRepository movieActorRepository = new MovieActorRepository();
        MovieService movieService = new MovieService();

        while (true) {
            System.out.println("""
                    관리 테이블 정하기
                    1. 영화
                    2. 배우
                    3. 감독
                    4. 배우별 영화
                    5. 감독별 영화
                    0. 종료
                    """);
            int res = scan.nextInt();
            if (res == 1) {
                movieService.start();
                } else if (res == 2) {
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
            else if (res == 4) {
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

                    } else if (cho == 2) {
                        movieActorRepository.select();
                    } else if (cho == 3) {
                        movieActorRepository.update();
                    } else if (cho == 0) {
                        break;
                    }
                }
            } else if (res == 0) {
                System.out.println("종료됩니다.");
                break;
            }
        }

    }
}