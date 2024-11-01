package com.green.userservice.user.vo;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class UserResponse {
    private Long id;

    private String email;

    //UUID
    private String userId;

    private String name;

    private String password;
}
