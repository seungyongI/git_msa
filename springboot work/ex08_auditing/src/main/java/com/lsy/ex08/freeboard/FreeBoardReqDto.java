package com.lsy.ex08.freeboard;

import com.lsy.ex08.user.User;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FreeBoardReqDto {
    private Long idx;
    private String title;
    private String content;
    private User user;
    private LocalDateTime regDate;
    private LocalDateTime modDate;
    private int viewCount;
}
