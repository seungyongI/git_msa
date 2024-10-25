package com.lsy.org.todo;

import com.lsy.org.kakao.jpa.KakaoEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "todos")
public class TodoEntity {
    @Id
    @Schema(hidden = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable=false, updatable=false)
    private Long id;
    
    @Schema(example = "할 일 제목")
    @Size(min = 2, max = 255)
    private String title;

    @Schema(example = "할 일 내용")
    private String content;

    private boolean complete;
    private LocalDate selectDate;

    @Schema(hidden = true)
    @ManyToOne
    @JoinColumn(name = "id")
    private KakaoEntity kakaoEntity;
}
