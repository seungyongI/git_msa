package org.example.repository;

import org.example.service.AdminMain;

import javax.swing.*;
import java.sql.*;
import java.util.Scanner;

import static org.example.repository.connection.DBConnectionUtil.getConnection;

public class MovieRepository {
    AdminMain adminMain = new AdminMain();

    public void insert() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        Scanner scan = new Scanner(System.in);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = getConnection();
            pstmt = conn.prepareStatement(
                    "INSERT INTO movie(m_name, m_genre, o_date, outline) VALUES (?, ?, ?, ?)");

            String m_name = scan.next();
            pstmt.setString(1, m_name);
            String m_genre = scan.next();
            pstmt.setString(2, m_genre);
            String o_date = scan.next();
            pstmt.setString(3, o_date);
            String outline = scan.next();
            pstmt.setString(4, outline);

            pstmt.executeUpdate();
            adminMain.start();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }

    public void select() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Scanner scan = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = getConnection();
            pstmt = conn.prepareStatement("select * from Movie where m_genre like (?)");

            while (true) {
                System.out.println("입력하시겠습니까?");
                System.out.println("""
                        1. 예
                        2. 아니오.
                        """);
                int cho = scan.nextInt();
                scan.nextLine(); // 입력 버퍼 비우기
                if (cho == 1) {
                    System.out.println("원하시는 장르를 입력하세요.");
                    System.out.print("장르 : ");
                    String m_genre = scan.nextLine();
                    pstmt.setString(1, m_genre);

                    rs = pstmt.executeQuery();

                    boolean row = true;
                    while (rs.next()) {
                        row = false;
                        System.out.printf("""
                                        제목 : %s, 장르 : %s, 개봉일 : %s
                                        설명 : %s
                                        %n""",
                                rs.getString("m_name"),
                                rs.getString("m_genre"),
                                rs.getString("o_date"),
                                rs.getString("outline"));
                    }
                    if (row) {
                        System.out.println("""
                                죄송합니다.
                                검색하신 장르는 없는 장르입니다.
                                다시 입력해주시길 바랍니다.
                                """);
                    }
                } else if (cho == 2) {
                    System.out.println("뒤로 돌아갑니다.");
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }

    public void update() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        Scanner scan = new Scanner(System.in);

        int cho = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = getConnection();
            System.out.println("""
                        수정 하시겠습니까?
                        1. 예
                        2. 아니오
                    """);
            cho = scan.nextInt();
            if (cho == 1) {
                pstmt = conn.prepareStatement(
                        "UPDATE Movie SET m_name = ?, m_genre = ?, o_date = ?, outline =? where a_id = ?");
                System.out.print("영화 이름 : ");
                String m_name = scan.next();
                pstmt.setString(1, m_name);
                System.out.println();
                System.out.print("영화 장르 : ");
                String m_genre = scan.next();
                pstmt.setString(2, m_genre);
                System.out.println();
                System.out.print("개봉일 : ");
                String o_date = scan.next();
                pstmt.setString(3, o_date);
                System.out.println();
                System.out.print("설명 : ");
                String outline = scan.next();
                pstmt.setString(4, outline);
                System.out.println();
                System.out.print("영화 아이디 : ");
                int a_id = scan.nextInt();
                pstmt.setInt(5, a_id);

                pstmt.executeUpdate();
                AdminMain.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }

    public void delete() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        Scanner scan = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = getConnection();

            pstmt = conn.prepareStatement(
                    "delete from Movie where m_id = ?");

            int m_id = scan.nextInt();
            pstmt.setInt(1, m_id);

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