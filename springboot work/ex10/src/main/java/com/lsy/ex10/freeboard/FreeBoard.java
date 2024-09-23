package com.lsy.ex10.freeboard;

import com.lsy.ex10.user.User;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class FreeBoard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //autoincrement
    private Long idx;

    private String title;
    private String content;

    @ManyToOne(cascade = CascadeType.ALL) // 영속성 전파
    private User user;

    @CreatedBy
    private String creAuthor;

    @LastModifiedBy
    private String modAuthor;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime regDate;

    @LastModifiedDate
    private LocalDateTime modDate;

    @Column(columnDefinition = "int default 0")
    private int view_count;
}