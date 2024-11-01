package com.green.userservice.user.service;

import com.green.userservice.error.UserException;
import com.green.userservice.user.jpa.UserEntity;
import com.green.userservice.user.jpa.UserRepository;
import com.green.userservice.user.vo.UserRequest;
import com.green.userservice.user.vo.UserResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

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
}
