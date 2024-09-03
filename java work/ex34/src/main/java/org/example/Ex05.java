package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

public class Ex05 {
    public static void main(String[] args) throws IOException {
        Path fp = Paths.get("d:/a/lines.file");

        List list = Arrays.asList("test", "content");

        Files.write(fp, list, StandardOpenOption.APPEND);

        List<String> readList = Files.readAllLines(fp);
        System.out.println(readList);

//        BufferedReader br = new BufferedReader(new FileReader("d:/a"));
//        br.readLine();
    }
}
