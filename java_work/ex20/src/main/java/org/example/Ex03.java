package org.example;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ex03 {

    public static void md1() {
        Path file = Paths.get("simple.txt");

//        BufferedWriter writer = null;

        // IOException 이 발생하기 때문에 try catch 로 해야 됨
        try (BufferedWriter writer = Files.newBufferedWriter(file)) {
            writer.write('A');
            writer.write("문자열도 적어 봅니다.");

        } catch (IOException e) {
            e.printStackTrace();
        }
//        finally {
//            try {
//                if (writer != null) {
//                    writer.close();
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }

    }

    public static void main(String[] args) {
        try {
            md1();
        } catch (Exception e) {
            System.out.println("파일만들기 실패");
//            e.printStackTrace();
        }
    }

}
