package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDBRepository {

    public List<Student> select() {
        List<Student> list = new ArrayList<>();
        Connection conn = null; // DB connect 객체
        PreparedStatement pstmt = null; // sql 작성 객체
        ResultSet rs = null; // sql문 테이블 담는 객체

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // jar 파일 확인
            conn = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3307/Lsy",
                    "root",
                    "1234"); // DB 연결
            pstmt = conn.prepareStatement("select * from student"); //sql 구문 작성
            rs = pstmt.executeQuery(); // sql 구문 실행

            while (rs.next()) {
                Student student = new Student(
                        rs.getInt("idx"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("email"),
                        rs.getString("password")
                );
                list.add(student);
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
        return list;
    }

}
