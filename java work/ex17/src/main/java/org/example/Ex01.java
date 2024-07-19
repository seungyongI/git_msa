package org.example;

import org.example.phone.MobilePhone;
import org.example.phone.SmartPhone;

public class Ex01 {
    public static void main(String[] args) {
        SmartPhone smartPhone
                = new SmartPhone("5.0",12345678);
        smartPhone.show();

        System.out.println();

        MobilePhone mobilePhone
                = new MobilePhone(123456);
        mobilePhone.show();
    }
}
