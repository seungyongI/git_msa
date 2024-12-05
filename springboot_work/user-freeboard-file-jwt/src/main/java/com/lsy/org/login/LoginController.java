package com.lsy.org.login;

import com.lsy.org.login.JWT.JWTManager;
import com.lsy.org.user.User;
import com.lsy.org.user.UserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwt;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class LoginController {

    private final LoginService loginService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JWTManager jwtManager;

    @PostMapping("/join")
    public ResponseEntity<String> join(@RequestBody JoinDto joinDto) {

        loginService.join(joinDto);

        return ResponseEntity.ok("success");
    }

    // swagger 사용 가능
    @GetMapping("/login")
    public ResponseEntity<String> redirectWithPost(
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            HttpServletResponse response) throws IOException {

        User user = userRepository.findByEmail(email).orElseThrow(
                () -> new UsernameNotFoundException(email)
        );

        String dbPassword = user.getPassword();

        boolean isMatch = passwordEncoder.matches(password, dbPassword);
        System.out.println("isMatch = " + isMatch);

        if (isMatch) {
            String jwt = jwtManager.createJWT(user.getEmail(), user.getRole());

            return ResponseEntity.ok(jwt);
        } else {

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("plz check email and password");
        }

    }

    @GetMapping("/check")
    public ResponseEntity<User> check(
            @RequestParam("jwt") String jwt,
            HttpServletResponse response) throws IOException {
        // JWT 유효성 검사
        Jws<Claims> claimsJws = jwtManager.getClaims(jwt);
        // 검사 성공 시 email 호출
        String email = claimsJws.getPayload().get("email").toString();
        // email 통해 DB 조회
        User user = userRepository.findByEmail(email).orElseThrow(
                () -> new UsernameNotFoundException(email)
        );

        return ResponseEntity.ok(user);
    }

}
