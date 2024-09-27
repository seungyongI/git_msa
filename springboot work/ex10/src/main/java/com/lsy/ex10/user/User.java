package com.lsy.ex10.user;

import com.lsy.ex10.freeboard.FreeBoard;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/*
    @Configuraion -> 객체 담는통 정의
    @Bean -> 그거 객체야
    @Component -> 그것도 객체야
    @ComponentScan -> 패키지 내용읽어서 객체 주입해줘
    @Autowired -> new 예약어 안쓰고 객체 자동 할당..
    private final -> @RequiredArgsConstructor -> 객체 자동할당

    @Entity -> 이거 테이블이야
    @Table -> table 이름 바꾸께
    @Id -> 기본키야 Primary 키야
 */

@Entity
@Table(name = "users")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
// Table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTOINCREMENT
    private Long idx;
    @Column(name = "username", nullable = false, length = 50)
    private String name;

    private int age;

    @Column(length = 100, unique = true)
    @Email
    private String email;

    @Column(length = 100)
    private String password;

    private LocalDateTime wdate;

    @OneToMany(mappedBy = "user",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private List<FreeBoard> list = new ArrayList<>();
}