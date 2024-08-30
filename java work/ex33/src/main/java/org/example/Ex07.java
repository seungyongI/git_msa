package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Ex07 {

    public static void main(String[] args) {
         List<Student> list = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/Lsy", "root", "1234")) {
//            Class.forName("com.mysql.cj.jdbc.Driver");

            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM student ORDER BY IDX DESC");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Student student = Student.builder()
                        .idx(rs.getInt("idx"))
                        .name(rs.getString("name"))
                        .age(rs.getInt("age"))
                        .email(rs.getString("email"))
                        .password(rs.getString("password"))
                        .regdate(rs.getObject("regdate", LocalDateTime.class))
                        .mydate(rs.getObject("mydate", LocalDateTime.class))
                        .build();

                list.add(student);
            }
            list.stream().forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
