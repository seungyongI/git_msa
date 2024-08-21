package org.example;

import java.util.HashSet;
import java.util.Set;

public class Ex01 {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("BOX");
        set.add("TOY");
        set.add("BOX");
        set.add("ROBOT");

        System.out.println(set);

//        box.equals(new String("BOX"));
//        set.add(new String("BOX"));
//        System.out.println(set);

        System.out.println("BOX".hashCode());
        System.out.println(new String("BOX").hashCode());

        Set<Student> set1 = new HashSet<>();
        set1.add(new Student());
        set1.add(new Student());

        System.out.println(set1);

        System.out.println(new Student().hashCode());
        System.out.println(new Student().hashCode());

    }
}
