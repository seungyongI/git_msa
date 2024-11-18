package com.green.orderservice.order.service;

import com.green.orderservice.order.vo.OrderResponse;
import com.green.orderservice.order.vo.OrderRequest;
import com.green.orderservice.order.vo.UserResponse;

public interface OrderService {
    UserResponse join(OrderRequest orderRequest);
    OrderResponse login(String email, String password);

}
