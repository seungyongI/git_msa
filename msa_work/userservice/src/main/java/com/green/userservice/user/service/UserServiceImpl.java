package com.green.userservice.user.service;

import com.green.userservice.error.UserException;
import com.green.userservice.jwt.JwtUtils;
import com.green.userservice.user.jpa.UserEntity;
import com.green.userservice.user.jpa.UserRepository;
import com.green.userservice.user.vo.LoginResponse;
import com.green.userservice.user.vo.UserRequest;
import com.green.userservice.user.vo.UserResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final JwtUtils jwtUtils;

    @Override
    public UserResponse join(UserRequest userRequest) {
        String reqEmail = userRequest.getEmail();

        userRepository.findByEmail(reqEmail)
                .ifPresent(user -> {
                    throw new UserException(String.format("'%s'는 이미 존재하는 이메일입니다.", reqEmail));
                });

        ModelMapper mapper = new ModelMapper();
        UserEntity userEntity = mapper.map(userRequest, UserEntity.class);
        userEntity.setUserId(UUID.randomUUID().toString());
        userEntity = userRepository.save(userEntity);

        UserResponse userResponse = mapper.map(userEntity, UserResponse.class);

        return userResponse;
    }

    @Override
    public LoginResponse login(String email, String password) {

        // email password 확인 하고 틀리면 Exception 처리
        UserEntity userEntity = userRepository.findByEmailAndPassword(email, password)
                .orElseThrow(
                        () -> new UserException("Invaild email or password")
                );

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setUserId(userEntity.getUserId());
        loginResponse.setAccessToken(jwtUtils.createAccessToken(userEntity.getEmail(),userEntity.getUserId()));
        loginResponse.setRefreshToken(jwtUtils.createRefreshToken(userEntity.getEmail()));

        return loginResponse;
    }

}
