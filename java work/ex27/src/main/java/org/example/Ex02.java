package org.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Ex02 {

    public static void main(String[] args) {

        List<Car> list = Arrays.asList(
                new Car("그랜져", 3000),
                new Car("K8", 3500),
                new Car("쏘렌토", 2200));

        for (Car car : list) {
            System.out.println(car);
        }

        System.out.println();
        System.out.println(list.get(0));

//        Collections.sort(list, new Comparator<Car>() {
//            @Override
//            public int compare(Car o1, Car o2) {
        // 오름차순
//                return o1.getDisp() - o2.getDisp();
        //내림차순
//                return o2.getDisp() - o1.getDisp();
//            }
//        });

        // 람다     변수값     리턴값
        Collections.sort(list, (o1, o2) -> o2.getDisp() - o1.getDisp());
//        Collections.sort(list, (o1,o2) -> o1.getName().compareTo(o2.getName()));
//        Collections.sort(list, (o1,o2) -> o2.getName().length() - o1.getName().length());


        System.out.println();
        for (Car car : list) {
            System.out.println(car);
        }
        System.out.println(list.get(0));
    }
}
