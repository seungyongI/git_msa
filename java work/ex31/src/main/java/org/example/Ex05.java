package org.example;

import java.util.Optional;

class ContInfo {
    String phone;
    String address;

    public ContInfo(String phone, String address) {
        this.phone = phone;
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }
}

public class Ex05 {
    public static void main(String[] args) {
        // Optional
        Optional<ContInfo> contInfo = Optional.of(
                                        new ContInfo(null, "KOREA DAEGU")
                                      );
        String phone = contInfo
                .map(contInfo1 -> contInfo1.getPhone())
                .orElse("There is no Phone Number");

        System.out.println("phone = " + phone);

        String address = contInfo
                .map(contInfo1 -> contInfo1.getAddress())
                .orElse("There is no Address");

        System.out.println("address = " + address);

//        String phone = null;
//        String address = null;
//
//        if (contInfo.getPhone() != null)
//            phone = contInfo.getPhone();
//        else
//            phone = "EMPTY";
//
//        if (contInfo.getAddress() != null)
//            address = contInfo.getAddress();
//        else
//            address = "EMPTY";
//
//        System.out.println("phone = " + phone);
//        System.out.println("address = " + address);
    }
}