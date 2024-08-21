package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DBRepository {

    public List<Student> select() {

        List<Student> list = new ArrayList<>();
        Connection conn = null; // DB 연결객체
        PreparedStatement pstmt = null; // sql 객체
        ResultSet rs = null; // 반환값 객체

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/Lsy",
                    "root",
                    "1234");
            pstmt = conn.prepareStatement("select * from student"); // sql 작성
            rs = pstmt.executeQuery(); // sql 실행

            while (rs.next()) {
                Student student = new Student();
                student.setIdx(rs.getInt("IDX"));
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));
                student.setEmail(rs.getString("email"));
                student.setPassword(rs.getString("password"));
                list.add(student);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }

        return null;
    }
}
