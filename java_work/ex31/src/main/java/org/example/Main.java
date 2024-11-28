package org.example;

import java.util.*;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        // [1, 3, 5, 7, 9] => [9, 7, 5, 3, 1]
        List<Integer> list = Arrays.asList(1, 3, 5, 7, 9);
//        list = new ArrayList<>(list);
//
//        System.out.println(list);
//        list.stream().forEach(s -> System.out.println(s));

        list.stream().forEach(System.out::println);

        // Consumer
//        Consumer<List<Integer>> consumer = mylist -> new Consumer<>() {
//            @Override
//            public void accept(Object o) {
//
//            }
//        };
//        Consumer<List<Integer>> consumer = mylist -> Collections.reverse(mylist);
        Consumer<List<Integer>> consumer = Collections::reverse;
        consumer.accept(list);

//        Collections.reverse(list);

        System.out.println(list);

    }
}