package org.example;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
public class Student {
    private int idx;
    private String name;
    private int age;
    private String email;
    private String password;
    private LocalDateTime regdate;
    private LocalDateTime mydate;
}