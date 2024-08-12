package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Main {

    public static void main(String[] args) {
        /*
        1.mysql 드라이버
        build.gradle 라이브러리
        2. Connection
        3. Statment
         */
        try{
            // jar 파일 추가 확인
            Class.forName("com.mysql.cj.jdbc.Driver");
            // DB 연결
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8","root","1234");
            //sql 구문 생성
            PreparedStatement pstmt = conn.prepareStatement("create table test (aa varchar(255), bb varchar(255))");
            // sql 구문 실행
            pstmt.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}