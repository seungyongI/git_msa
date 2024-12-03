package com.green.orderservice.order.service;

import com.green.orderservice.order.vo.OrderRequest;
import com.green.orderservice.order.vo.OrderResponse;

import java.util.List;

public interface OrderService {
    OrderResponse order(OrderRequest orderRequest, String userId);
    List<OrderResponse> list(String userId);
}