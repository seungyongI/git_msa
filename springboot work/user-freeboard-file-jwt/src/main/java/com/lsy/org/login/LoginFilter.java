package com.lsy.org.login;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lsy.org.JWT.JWTManager;
import com.lsy.org.user.User;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;

public class LoginFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;
    private final JWTManager jwtManager;

    public LoginFilter(AuthenticationManager authenticationManager, JWTManager jwtManager) {

        this.setFilterProcessesUrl("/login");
        this.authenticationManager = authenticationManager;
        this.jwtManager = jwtManager;

    }

    // 로그인 시도 할때 호출 되는 메서드
    @Override
    public Authentication attemptAuthentication(
            HttpServletRequest request,
            HttpServletResponse response) throws AuthenticationException {

//        String username = this.obtainUsername(request);
//        System.out.println("username = " + username);

//        try {
//            JoinDto joinDto = new ObjectMapper().readValue(request.getInputStream(), JoinDto.class);
//            System.out.println("joinDto = " + joinDto);
//        } catch(Exception e){
//            e.printStackTrace();
//        }

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(email, password);

        return authenticationManager.authenticate(token);
    }

    // login success -> JWT 토큰발행
    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {

        UserDetails userDetails = (UserDetails) authResult.getPrincipal();
        System.out.println(userDetails);

        String role = "";
        for (var auth : userDetails.getAuthorities()) {
            role = auth.getAuthority();
        }

        String jwt = jwtManager.createJWT(userDetails.getUsername(), role);
        response.getWriter().write(jwt);
    }

    // login fail -> username password 를 확인하세요
    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request,
                                              HttpServletResponse response,
                                              AuthenticationException failed) throws IOException, ServletException {
//        super.unsuccessfulAuthentication(request, response, failed);
        System.out.println("실패");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getWriter()
                .write("check email and password");
    }
}