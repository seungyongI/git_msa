package com.green.orderservice.order;

import com.green.orderservice.order.service.OrderService;
import com.green.orderservice.order.vo.OrderRequest;
import com.green.orderservice.order.vo.OrderResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order-service")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    // user order
    @PostMapping("/{userId}/order")
    public ResponseEntity<OrderResponse> userOrder(@PathVariable String userId, @RequestBody OrderRequest orderRequest) {
        OrderResponse orderResponse = orderService.order(orderRequest, userId);

        return ResponseEntity.ok(orderResponse);
    }
    // watch list
    @GetMapping("/{userId}/list")
    public ResponseEntity<List<OrderResponse>> list(@PathVariable String userId) {
        List<OrderResponse> orderResponses = orderService.list(userId);

        return ResponseEntity.ok(orderResponses);
    }
}
