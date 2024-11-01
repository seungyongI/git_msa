package com.green.userservice.user.service;

import com.green.userservice.user.vo.UserRequest;
import com.green.userservice.user.vo.UserResponse;

public interface UserService {
    UserResponse join(UserRequest userRequest);

}
