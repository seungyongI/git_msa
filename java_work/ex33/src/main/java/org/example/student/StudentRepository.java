package org.example.student;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentRepository {

    public void select() {
        List<Student> list = new ArrayList<>();
        try (Connection conn
                     = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3307/Lsy", "root", "1234")) {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM student ORDER BY IDX DESC");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Student student = Student.builder()
                        .name(rs.getString("name"))
                        .idx(rs.getInt("idx"))
                        .age(rs.getInt("age"))
                        .email(rs.getString("email"))
                        .password(rs.getString("password"))
                        .regdate(rs.getObject("regdate", LocalDateTime.class))
                        .mydate(rs.getObject("mydate", LocalDateTime.class))
                        .build();
                list.add(student);
            }
            list.stream()
                    .forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insert() {
        LocalDateTime mydate = LocalDateTime.now();

        try (Connection conn
                     = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3307/Lsy", "root", "1234")) {
            PreparedStatement pstmt
                    = conn.prepareStatement("""
                        INSERT INTO student 
                            (NAME,age,email,password,mydate)
                        values
                            (?,?,?,?,?)
                    """);
            pstmt.setString(1, "홍길동");
            pstmt.setInt(2, 30);
            pstmt.setString(3, "aaaa@naver.com");
            pstmt.setString(4, "password");
            pstmt.setObject(5, mydate);

            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update() {
        Scanner scan = new Scanner(System.in);
        try (Connection conn
                     = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3307/Lsy", "root", "1234")) {
            PreparedStatement pstmt
                    = conn.prepareStatement("""
                        update student set name = ?, age = ?, email = ?, password = ? where idx = ?"
                    """);
            String name = scan.nextLine();
            pstmt.setString(1, name);
            int age = scan.nextInt();
            pstmt.setInt(2, age);

            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 사용자 존재 유무 확인
    public Student findByIdx(int idx) {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3307/Lsy", "root", "1234")) {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM student WHERE idx = ?");
            pstmt.setInt(1, idx);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return Student.builder()
                        .idx(rs.getInt("idx"))
                        .name(rs.getString("name"))
                        .email(rs.getString("email"))
                        .build();
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}