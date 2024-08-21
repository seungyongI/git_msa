package org.example;

import java.util.Set;
import java.util.TreeSet;

public class Ex02 {

    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>();

        set.add(4);
        set.add(1);
        set.add(2);
        set.add(3);

        System.out.println(set);

        Set<Student> set1 = new TreeSet<>();
        Student student1 = new Student();
        student1.setName("홍길동");
        student1.setAge(30);
        Student student2 = new Student();
        student2.setName("김길동");
        student2.setAge(20);
        Student student3 = new Student();
        student3.setName("이길동");
        student3.setAge(25);

        set1.add(student1);
        set1.add(student2);
        set1.add(student3);

        System.out.println(set1);


    }
}
