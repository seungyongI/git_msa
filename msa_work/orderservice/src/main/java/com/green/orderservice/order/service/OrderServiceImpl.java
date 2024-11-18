package com.green.orderservice.order.service;

import com.green.orderservice.error.OrderException;
import com.green.orderservice.jwt.JwtUtils;
import com.green.orderservice.order.jpa.OrderEntity;
import com.green.orderservice.order.jpa.OrderRepository;
import com.green.orderservice.order.vo.OrderResponse;
import com.green.orderservice.order.vo.OrderRequest;
import com.green.orderservice.order.vo.UserResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final JwtUtils jwtUtils;

    @Override
    public UserResponse join(OrderRequest orderRequest) {
        String reqEmail = orderRequest.getEmail();

        orderRepository.findByEmail(reqEmail)
                .ifPresent(user -> {
                    throw new OrderException(String.format("'%s'는 이미 존재하는 이메일입니다.", reqEmail));
                });

        ModelMapper mapper = new ModelMapper();
        OrderEntity orderEntity = mapper.map(orderRequest, OrderEntity.class);
        orderEntity.setUserId(UUID.randomUUID().toString());
        orderEntity = orderRepository.save(orderEntity);

        UserResponse userResponse = mapper.map(orderEntity, UserResponse.class);

        return userResponse;
    }

    @Override
    public OrderResponse login(String email, String password) {

        // email password 확인 하고 틀리면 Exception 처리
        OrderEntity orderEntity = orderRepository.findByEmailAndPassword(email, password)
                .orElseThrow(
                        () -> new OrderException("Invaild email or password")
                );

        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setUserId(orderEntity.getUserId());
        orderResponse.setAccessToken(jwtUtils.createAccessToken(orderEntity.getEmail(), orderEntity.getUserId()));
        orderResponse.setRefreshToken(jwtUtils.createRefreshToken(orderEntity.getEmail()));

        return orderResponse;
    }

}
