package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.Scanner;

public class MovieDB {

    public void insert() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        Scanner scan = new Scanner(System.in);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3307/Mymh",
                    "root",
                    "1234"
            );
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
            conn = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3307/Mymh",
                    "root",
                    "1234"
            );
            pstmt = conn.prepareStatement("select * from movie where M_name like (?)");

            String name = scan.next();
            pstmt.setString(1,name);

            rs = pstmt.executeQuery();
            while(rs.next()) {
                System.out.printf("""
                        M_id = %d
                        M_name = %s genre = %s release_date = %s synopsis = %s
                        %n""",
                        rs.getInt("M_id"),
                        rs.getString("M_name"),
                        rs.getString("genre"),
                        rs.getString("release_date"),
                        rs.getString("synopsis"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }

}
