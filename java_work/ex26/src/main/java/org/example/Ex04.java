package org.example;

import java.util.Comparator;
import java.util.TreeSet;

public class Ex04 {

    public static void main(String[] args) {

//        Comparator<String> comparator = new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o2.length()-o1.length();
//            }
//        };

//        TreeSet<String> treeSet = new TreeSet<>(comparator);

                                      // 람다    변수명      리턴값
        TreeSet<String> treeSet = new TreeSet<>((o1,o2) -> o2.length()-o1.length());

        treeSet.add("BBB");
        treeSet.add("AA");
        treeSet.add("CCCC");
        treeSet.add("D");

        System.out.println(treeSet);


    }
}
