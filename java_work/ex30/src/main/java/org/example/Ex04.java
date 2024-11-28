package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Ex04 {
    public static void main(String[] args) {
        Stream.of(1, 2, 3, 4, 5, 6)
                .filter(n -> n % 2 == 1)
                .forEach(s -> System.out.println("Output = " + s));

        List<Student> list = Arrays.asList(
                new Student(1, "홍길동", 20, "aaa@naver.com", "password"),
                new Student(2, "박길동", 30, "aaa@naver.com", "password"),
                new Student(3, "김길동", 40, "aaa@naver.com", "password")
        );

        int result = 0;

        for (Student student : list) {
            result += student.getAge();
            System.out.println(student);
        }
        System.out.println("나이의 총합 = " + result);

        // Stream
        // 나이의 총합
        result = list.stream()
                .mapToInt(s -> s.getAge())
                .sum();

        System.out.println("나이의 총합 = " + result);

        // 나이가 30 이상인 사람 출력
        list.stream()
                .filter(student -> student.getAge() >= 30)
                .forEach(s -> {
                    System.out.println("Content");
                    System.out.println(s.getName());
                });

        list.stream()
                .filter(student -> student.getAge() >= 30)
                .mapToInt(m -> m.getAge())
                .forEach(age ->
                        System.out.println(age)
                );
    }
}