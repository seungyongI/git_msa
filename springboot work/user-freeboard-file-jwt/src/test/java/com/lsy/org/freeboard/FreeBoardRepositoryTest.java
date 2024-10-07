package com.lsy.org.freeboard;

import com.lsy.org.user.User;
import com.lsy.org.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class FreeBoardRepositoryTest {

    // Spring boot 객체 담는 곳에서 freeBoardRepository 객체 가져오기
    @Autowired
    FreeBoardRepository freeBoardRepository;

    @Autowired
    UserRepository userRepository;

    //    @Transactional insertTest() DB 저장 X
    @Test
    void insertTest() {
        User user = User.builder()
                .name("이길동")
                .age(20)
                .email("f123@naver.com")
                .password("password")
                .build();
        // 1. UserRepository
//        userRepository.save(user);

        // 2. Cascade JPA 속성 (FreeBoard class user 확인)
        FreeBoard freeBoard = FreeBoard.builder()
                .title("Title")
                .content("Content")
                .user(user)
                .build();
        freeBoardRepository.save(freeBoard);
    }

    @Test
    void selectTest() {
        List<FreeBoard> list = freeBoardRepository.findAll();

        list.stream().forEach(System.out::println);
    }

    @Test
    void deleteTest() {
        freeBoardRepository.deleteById(3L);
    }

    @Test
    void updateTest() {
//        User user = User.builder()
//                .idx(2l)
//                .name("홍진호")
//                .age(22)
//                .email("ccc@naver.com")
//                .password("password")
//                .build();
//
//        userRepository.save(user);

        User user = userRepository.findById(1l).orElseThrow();

        FreeBoard freeBoard = FreeBoard.builder()
                .idx(2l)
                .title("제목이야")
                .content("내용이야")
                .user(user)
                .build();
        freeBoardRepository.save(freeBoard);
    }
}