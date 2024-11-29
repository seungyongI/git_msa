package com.green.orderservice.order.service;

import com.green.orderservice.order.jpa.OrderEntity;
import com.green.orderservice.order.jpa.OrderRepository;
import com.green.orderservice.order.message.KafkaProducer;
import com.green.orderservice.order.vo.OrderRequest;
import com.green.orderservice.order.vo.OrderResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final KafkaProducer kafkaProducer;
    private final Environment environment;

    @Override
    public OrderResponse order(OrderRequest orderRequest, String userId) {
        String myTopic = environment.getProperty("spring.kafka.topic-name");

        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setProductId(orderRequest.getProductId());
        orderEntity.setQty(orderRequest.getQty());
        orderEntity.setUnitPrice(orderRequest.getUnitPrice());
        orderEntity.setOrderId(UUID.randomUUID().toString());
        orderEntity.setUserId(userId);
        orderEntity.setTotalPrice(orderRequest.getUnitPrice() * orderRequest.getQty());
        OrderEntity dbOrderEntity = orderRepository.save(orderEntity);

        // 메시지 생산
        kafkaProducer.sendMessage(myTopic, orderEntity);

        return new ModelMapper().map(dbOrderEntity, OrderResponse.class);
    }

    @Override
    public List<OrderResponse> list(String userId) {
        List<OrderEntity> orderEntities = orderRepository.findAllByUserId(userId);
        List<OrderResponse> orderResponses = new ArrayList<>();

        orderEntities.stream().forEach(orderEntity -> {
            orderResponses.add(new ModelMapper().map(orderEntity, OrderResponse.class));
        });
        return orderResponses;
    }
}
