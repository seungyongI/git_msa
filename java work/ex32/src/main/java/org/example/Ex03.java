package org.example;

import java.util.stream.Stream;

public class Ex03 {
    public static void main(String[] args) {
        Stream<String> stream1 = Stream.of("aa","bb");
        Stream<String> stream2 = Stream.of("cc","dd");

        Stream.concat(stream1, stream2)
                .forEach(s -> System.out.print(s+"\t"));

        Stream<Integer> stream3 = Stream.of(11,22,33);
    }
}
