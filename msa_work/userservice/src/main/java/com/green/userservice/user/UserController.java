package com.green.userservice.user;

import com.green.userservice.feign.FirstClient;
import com.green.userservice.user.service.UserService;
import com.green.userservice.user.vo.LoginResponse;
import com.green.userservice.user.vo.UserRequest;
import com.green.userservice.user.vo.UserResponse;
import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-service")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final FirstClient firstClient;

    @GetMapping("short-work")
    @Timed("short.work")
    public String shortWork() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Short work completed";
    }

    @GetMapping("long-work")
    @Timed("long.work")
    public String longWork() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Long work completed";
    }

    @GetMapping("test")
    public String test() {
        System.out.println("Feign Start");
        System.out.println(firstClient.getTest());
        System.out.println("Feign End");
        return "This is User Service";
    }

    @PostMapping("/join")
    public ResponseEntity<UserResponse> joinUser(@RequestBody UserRequest userRequest) {
        UserResponse userResponse = userService.join(userRequest);

        return ResponseEntity.ok(userResponse);
    }

    @GetMapping("/list")
    public ResponseEntity<List<UserResponse>> ListUser() {

        return ResponseEntity.ok(userService.list());
    }

    @GetMapping("/getUser/{userId}")
    public ResponseEntity<UserResponse> getUser(@PathVariable(value = "userId") String userId) {
        UserResponse userResponse = userService.getUser(userId);

        return ResponseEntity.ok(userResponse);
    }

    @GetMapping("/login")
    public ResponseEntity<LoginResponse> getUser(
            @RequestParam(value = "email") String email,
            @RequestParam(value = "password") String password) {

        LoginResponse loginResponse = userService.login(email, password);

        return ResponseEntity.ok(loginResponse);
    }

    @GetMapping("kakaologin")
    public ResponseEntity<String> kakaoLogin() {

        return ResponseEntity.ok(null);
    }

}