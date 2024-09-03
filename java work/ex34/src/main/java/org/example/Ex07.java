package org.example;

import javax.xml.crypto.Data;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ex07 {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("cc");

//        Files.createFile(path);

        //NIO java
        try (DataOutputStream outputStream = new DataOutputStream(Files.newOutputStream(path))) {
            outputStream.writeChar('A');
            outputStream.writeInt(65);
            outputStream.writeInt(10);
//            outputStream.write(10);
//            outputStream.write(65);
//            outputStream.write(10);
//            outputStream.write(65);
//            outputStream.write(10);
//            outputStream.write(1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // IO java
//        try (OutputStream outputStream = new BufferedOutputStream(new FileOutputStream("aa"))){
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
