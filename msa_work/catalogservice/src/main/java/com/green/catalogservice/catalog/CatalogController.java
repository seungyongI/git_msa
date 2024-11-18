package com.green.catalogservice.catalog;

import com.green.catalogservice.catalog.service.CatalogService;
import com.green.catalogservice.catalog.vo.CatalogResponse;
import com.green.catalogservice.catalog.vo.CatalogRequest;
import com.green.orderservice.order.vo.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class CatalogController {
    private final CatalogService userService;

    @PostMapping("/join")
    public ResponseEntity<CatalogResponse> joinUser(@RequestBody CatalogRequest catalogRequest) {

        CatalogResponse catalogResponse = orderser.join(catalogRequest);

        return ResponseEntity.ok(catalogResponse);
    }

    @GetMapping("/login")
    public ResponseEntity<String> getUser(
            @RequestParam(value = "email") String email,
            @RequestParam(value = "password") String password) {

        CatalogResponse catalogResponse = userService.login(email, password);

        return ResponseEntity.ok(null);
    }

    @GetMapping("kakaologin")
    public ResponseEntity<String> kakaoLogin() {

        return ResponseEntity.ok(null);
    }

}
