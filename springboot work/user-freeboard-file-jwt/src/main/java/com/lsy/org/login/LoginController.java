package com.lsy.org.login;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@RestController
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/join")
    public String join(@RequestBody JoinDto joinDto){
        loginService.join(joinDto);
        return "success";
    }
    // swagger 사용 가능
    @GetMapping("/login")
    public void redirectWithPost(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            HttpServletResponse response) throws IOException {

        response.sendRedirect("/login");
    }
}
