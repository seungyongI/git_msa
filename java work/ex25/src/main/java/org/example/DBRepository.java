package org.example;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBRepository {
    /*
    1. Class.forname jar 파일 추가확인
    2. Connection DB연결
    3. PrepareStatement sql 구문작성
    4. sql 구문 실행
    executeUpdate(); -> insert, update, delete, create, alter 문 실행할 때
    executeQuery; -> select 실행할 때
     */

    public void insert() {
        Connection conn = null;
        PreparedStatement pstmt = null;

        /*
         Exception 소스 상에서 해결을 해야 되고
         RuntimeException 소스 상에서 해결 안 해도 됨

         강제 예외 발생
         throw new RuntimeException();
         강제 예외 발생
         throw new Exception();
         */

        try {
            // DB 연결
            conn = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3307/Lsy",
                    "root",
                    "1234");

            // sql 생성
            pstmt = conn.prepareStatement("insert into student(name,age) values(?,?)");
            String name = JOptionPane.showInputDialog("이름");
            pstmt.setString(1, name);
            int age = Integer.parseInt(JOptionPane.showInputDialog("나이"));
            pstmt.setInt(2, age);

            //sql 실행
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
            }
        }
    }

    public void select() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        //select 해서 반환되는 table 받기
        ResultSet rs = null;

        try {
            // DB 연결
            conn = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3307/Lsy",
                    "root",
                    "1234");

            // sql 생성
            pstmt = conn.prepareStatement(
                    "select * from student");

            // sql 실행
            rs = pstmt.executeQuery();
            while(rs.next()) {
//                System.out.print("idx = " + rs.getInt("idx") + "\t");
//                System.out.print("name = " + rs.getString("name") + "\t");
//                System.out.print("age = " + rs.getInt("age"));
//                System.out.println();
                System.out.printf("""
                                idx = %d
                                name = %s age = %d
                                %n""",
                        rs.getInt("idx"),
                rs.getString("name"),
                rs.getInt("age"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
            }
        }
    }

    public void update() {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // DB 연결
            conn = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3307/Lsy",
                    "root",
                    "1234");

            // sql 생성
            pstmt = conn.prepareStatement(
                    "update student set name = ?, age = ? where idx = ?");
            String name = JOptionPane.showInputDialog("이름");
            pstmt.setString(1, name);

            int age = Integer.parseInt(JOptionPane.showInputDialog("나이"));
            pstmt.setInt(2, age);

            int idx = Integer.parseInt(JOptionPane.showInputDialog("idx"));
            pstmt.setInt(3, idx);

            // sql 실행
            pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
            }
        }
    }

    public void delete() {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // DB 연결
            conn = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3307/Lsy",
                    "root",
                    "1234");

            // sql 생성
            pstmt = conn.prepareStatement(
                    "delete from student where idx = ?");

            int idx = Integer.parseInt(JOptionPane.showInputDialog("idx"));
            pstmt.setInt(1, idx);

            // sql 실행
            pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
            }
        }
    }
}
