package org.example;

import java.util.Random;

@FunctionalInterface
interface RAN {

    int ran();

    default int doA() {
        return 10;
    }
}

public class Ex02 {
    public static void main(String[] args) {
        RAN ran = () -> new Random().nextInt(50);

        for (int i = 0; i < 10; i++)
            System.out.println(ran.ran());
    }
}
