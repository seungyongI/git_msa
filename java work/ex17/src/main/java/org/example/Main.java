package org.example;

import org.example.aa.KiaCar;
import org.example.aa.SamsungCar;

public class Main {

    public static void main(String[] args) {

        SamsungCar samsungCar = new SamsungCar("XM3","Pretty","Samsung");
        KiaCar kiaCar = new KiaCar();


        System.out.println(samsungCar);
        System.out.println(kiaCar);
    }
}