package org.example.repository;

import org.example.service.AdminMain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import static org.example.repository.connection.DBConnectionUtil.getConnection;

public class MovieActorRepository {
    AdminMain adminMain = new AdminMain();

    public void select() {
        Connection conn;
        PreparedStatement pstmt;
        ResultSet rs;
        Scanner scan = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = getConnection();
            pstmt = conn.prepareStatement
                    ("select ma.m_name, ma.a_name, m.m_genre, m.o_date, m.outline from MovieActor ma inner join Movie m on (ma.m_id = m.m_id) where ma.a_name like (?)");

            while (true) {
                System.out.println("입력하시겠습니까?");
                System.out.println("""
                        1. 예
                        2. 아니오.
                        """);
                int cho = scan.nextInt();
                scan.nextLine(); // 입력 버퍼 비우기
                if (cho == 1) {
                    System.out.println("원하시는 배우 이름을 입력하세요.");
                    System.out.print("배우 이름 : ");
                    String a_name = scan.nextLine();
                    pstmt.setString(1, a_name);

                    rs = pstmt.executeQuery();

                    boolean row = true;
                    while (rs.next()) {
                        row = false;
                        System.out.printf("""
                                        제목 : %s, 배우 : %s, 장르 : %s, 개봉일 : %s
                                        설명 : %s
                                        %n""",

                                rs.getString("m_name"),
                                rs.getString("a_name"),
                                rs.getString("m_genre"),
                                rs.getString("o_date"),
                                rs.getString("outline"));
                    }
                    if (row) {
                        System.out.println("""
                                죄송합니다.
                                검색하신 배우는 없는 배우입니다.
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
                        "UPDATE MovieActor SET m_name = ?, a_name = ? where (m_id = ? and a_id = ?)");
                System.out.print("영화 이름 : ");
                String m_name = scan.next();
                pstmt.setString(1, m_name);
                System.out.println();
                System.out.print("배우 이름 : ");
                String d_name = scan.next();
                pstmt.setString(2, d_name);
                System.out.println();
                System.out.print("영화 아이디 : ");
                int m_id = scan.nextInt();
                pstmt.setInt(3, m_id);
                System.out.print("배우 아이디 : ");
                int a_id = scan.nextInt();
                pstmt.setInt(4, a_id);

                pstmt.executeUpdate();
                adminMain.start();
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
                    "delete from MovieActor where m_id = ?");

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