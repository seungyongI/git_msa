package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Ex06 {

    public static void main(String[] args) {

        try {
            //DB 연결 유지 클래스
            Connection conn
                    = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Lsy", "root", "1234");
            System.out.println("asdf");
            //SQL 구문 담는 객체
            PreparedStatement pstmt
                    = conn.prepareStatement("INSERT INTO student values ('김길동',100,100,100)");

            pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
