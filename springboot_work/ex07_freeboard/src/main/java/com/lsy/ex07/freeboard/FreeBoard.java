package com.lsy.ex07.freeboard;

import com.lsy.ex07.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Getter
@Setter
public class FreeBoard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //autoincrement
    private Long idx;

    private String title;
    private String content;

    @ManyToOne(cascade = CascadeType.ALL)
    private User user;

    private LocalDateTime regDate;
    private LocalDateTime modDate;

    // 게시물 조회수
    private int view_count;
}