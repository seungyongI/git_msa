package org.example;

import java.util.*;

public class Ex03 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("BOX");
        list.add("ROBOT");
        list.add("TEST");

        int idx = Collections.binarySearch(list, "ROBOT");

        System.out.println("idx = " + idx);
        System.out.println(list.get(idx));
    }
}
