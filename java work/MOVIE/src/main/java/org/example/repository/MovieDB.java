package org.example.repository;

import java.sql.*;
import java.util.Scanner;

import static org.example.repository.connection.DBConnectionUtil.getConnection;

public class MovieDB {

    public void insert() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        Scanner scan = new Scanner(System.in);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
//            conn = DriverManager.getConnection(
//                    "jdbc:mysql://127.0.0.1:3307/Mymh",
//                    "root",
//                    "1234"
//            );
            conn = getConnection();
            pstmt = conn.prepareStatement(
                    "INSERT INTO movie(M_name, genre, release_date, Synopsis) VALUES (?, ?, ?, ?)");

            String M_name = scan.next();
            pstmt.setString(1, M_name);
            String genre = scan.next();
            pstmt.setString(2, genre);
            String release_Date = scan.next();
            pstmt.setString(3, release_Date);
            String synopsis = scan.next();
            pstmt.setString(4, synopsis);

            pstmt.executeUpdate();

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
//            conn = DriverManager.getConnection(
//                    "jdbc:mysql://127.0.0.1:3307/Mymh",
//                    "root",
//                    "1234"
//            );
            conn = getConnection();
            pstmt = conn.prepareStatement("select * from movie where genre like (?)");

            while (true) {
                System.out.println("입력하시겠습니까?");
                System.out.println("""
                        1. 예
                        2. 아니오.
                        """);
                int cho = scan.nextInt();
                scan.nextLine(); // 입력 버퍼 비우기
                if (cho == 1) {
                    System.out.println("영화 장르를 입력하세요.");
                    String genre = scan.nextLine();
                    pstmt.setString(1, genre);

                    rs = pstmt.executeQuery();

                    boolean row = true;
                    while (rs.next()) {
                        row = false;
                        System.out.printf("""
                                        번호 = %d
                                        영화제목 = %s 장르 = %s 개봉일 = %s 개요 = %s
                                        %n""",
                                rs.getInt("M_id"),
                                rs.getString("M_name"),
                                rs.getString("genre"),
                                rs.getString("release_date"),
                                rs.getString("synopsis"));
                    }
                    if (row) {
                        System.out.println("""
                                죄송합니다.
                                검색하신 영화는 없는 영화입니다.
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
}