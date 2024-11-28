package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex03 {
    public static void main(String[] args) {
        /*
        Arrays.asList 사용하면 add, remove 안 됨.
        list.add("이거 안 됨");
        list.remove("TOY");
         */
        List<String> list = Arrays.asList("TOY","BOX","ROBOT");

        list = new ArrayList<>(list);
        list.add("add");

        System.out.println(list);
    }
}
