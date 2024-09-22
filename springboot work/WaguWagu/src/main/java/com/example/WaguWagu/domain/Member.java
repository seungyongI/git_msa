package com.example.WaguWagu.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(name = "m_id", unique = true, nullable = false, length = 20)
    @Size(min = 5)
    private String memberId;

    @Column(nullable = false, length = 20)
    @Size(min = 8)
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,20}$",
            message = "비밀번호는 8자 이상 20자 이하이며, 영문자, 숫자, 특수문자를 각각 하나 이상 포함해야 합니다.")
    // 예외 생성을 통한 비밀번호 강도 검증(동일 문자 포함, 아이디와 이메일과 비슷한 비밀번호 등)이 좋을 듯 Pattern은 임시
    private String password;

    @Column(unique = true, length = 100)
    @Email
    private String email;

    private String phoneNumber;

    @Column(nullable = false)
    private int age;
    @Column(nullable = false)
    private String gender;

    @Column(columnDefinition = "TEXT")
    private String profileImage;


    private String nickname;
    private int role;
    private LocalDateTime creDate;
    private int provider;
}