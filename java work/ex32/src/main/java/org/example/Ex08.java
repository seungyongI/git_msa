package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class Ex08 {
    public static void main(String[] args) {
        List<Integer> oddlist = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .filter(integer -> integer % 2 == 1)
                .collect(
                        () -> new ArrayList<Integer>()
                        , (list, item) -> list.add(item)
                        , (integers, integers2) -> {}
                );

        System.out.println(oddlist);

        List<Integer> evenlist = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .filter(integer -> integer % 2 == 0)
                .collect(
                        () -> new ArrayList<Integer>()
                        , ArrayList::add
                        , (integers, integers2) -> {}
                );
        System.out.println(evenlist);

        Set<Integer> mset = Stream.of(10, 20, 30, 10, 40, 30)
                .collect(
                        () -> new HashSet<Integer>()
                        ,(set, item) -> set.add(item)
                        , (integers, integers2) -> {}
                );
        System.out.println(mset);
    }
}
