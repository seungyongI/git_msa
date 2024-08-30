package org.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MyDayFormat {
    public static String myFormat(LocalDateTime localDateTime) {
        return DateTimeFormatter.ofPattern("MM/dd").format(LocalDateTime.now());
    }

    public static String myFormat(String format, LocalDateTime localDateTime) {
        return DateTimeFormatter.ofPattern(format).format(LocalDateTime.now());
    }
}
