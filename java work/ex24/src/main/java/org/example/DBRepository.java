package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DBRepository {

    /*
    1. insert
    2. select
    3. update
    4. delete
     */

    // insert 되는 거
    public void insert() {
        try {
            Scanner scan = new Scanner(System.in);
            System.out.println("이름입력");
            String name = scan.next();
            System.out.println("나이입력");
            int age = scan.nextInt();

            // 1. mysql jar 추가 확인
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2. connection 연결
            Connection conn = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/Lsy",
                            "root",
                            "1234");
            System.out.println("연결성공");
            // 3. sql 문 작성
            PreparedStatement pstmt
                    = conn.prepareStatement("INSERT INTO aa (name,age) VALUES (?,?)");
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            // 4. sql 문 실행
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void select() {
        System.out.println("select");
    }
}