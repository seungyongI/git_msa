package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Ex06 {
    public static void main(String[] args) {
        //Stream
        List<String> list = Arrays.asList("aaa","bbbb","ccccc","dddddd");
        
        list.stream()
                .map(s -> s.toUpperCase())
                .forEach(System.out::println);
        System.out.println();

        list.stream()
                .map(s -> s.replace("aa","AA"))
                .forEach(System.out::println);
        System.out.println();

        list.stream()
                .map(s -> s.length())
                .forEach(System.out::println);
        System.out.println();

        // Optional map method -> return Optional<T>
        // 반환값이 없으면 orElse 사용해서 반환값 작성 가능
        Optional<String> os1 = Optional.of("abCD efg");
        Optional<String> os2 = os1.map(String::toUpperCase);
        String result = os1.map(String::toUpperCase).orElse("EMPTY");

        System.out.println(os2);
        System.out.println(os2.get());

        Optional<String> os3 = os1.map(s -> s.replace(" ", "_"))
                                  .map(s -> s.toLowerCase());

        System.out.println(os3);
        System.out.println(os3.get());

        os3.ifPresent(System.out::println);

        Optional<Integer> os4 = os1.map(s -> s.length());

        System.out.println(os4);
        System.out.println(os4.get());
    }
}