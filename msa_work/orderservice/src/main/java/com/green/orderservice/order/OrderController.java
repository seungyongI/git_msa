package com.green.orderservice.order;

import com.green.orderservice.order.service.OrderService;
import com.green.orderservice.order.vo.OrderResponse;
import com.green.orderservice.order.vo.OrderRequest;
import com.green.orderservice.order.vo.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService userService;

    @PostMapping("/join")
    public ResponseEntity<OrderResponse> joinUser(@RequestBody OrderRequest orderRequest) {

        OrderResponse orderResponse = orderser.join(orderRequest);

        return ResponseEntity.ok(orderResponse);
    }

    @GetMapping("/login")
    public ResponseEntity<String> getUser(
            @RequestParam(value = "email") String email,
            @RequestParam(value = "password") String password) {

        OrderResponse orderResponse = userService.login(email, password);

        return ResponseEntity.ok(null);
    }

    @GetMapping("kakaologin")
    public ResponseEntity<String> kakaoLogin() {

        return ResponseEntity.ok(null);
    }

}
