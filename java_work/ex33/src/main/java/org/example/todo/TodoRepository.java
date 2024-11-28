package org.example.todo;

import org.example.TodoMain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.time.LocalDate;

public class TodoRepository {
    public void select() {
    }

    public void insert() {
        if(TodoMain.student == null) {
            System.out.println("please Login");
            return;
        }
        try (Connection conn
                     = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3307/Lsy", "root", "1234")) {
            PreparedStatement pstmt
                    = conn.prepareStatement("""
                        INSERT INTO todo
                        (dodate, content, student_idx)
                        values
                        (?,?,?)
                    """);
            pstmt.setObject(1, LocalDate.of(2024,9,10));
            pstmt.setString(2, "Eng_study");
            pstmt.setInt(3, TodoMain.student.getIdx());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}