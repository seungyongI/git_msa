package org.example;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Person[] parr = {
                new Person("dddd", 50),
                new Person("a", 40),
                new Person("ccc", 30),
                new Person("bb", 20),

        };
        Arrays.sort(parr);
        System.out.println(Arrays.toString(parr));
    }

}