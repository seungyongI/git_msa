package com.lsy.org.login.JWT;

import com.lsy.org.login.LoginUserDetails;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JWTFilter extends OncePerRequestFilter {

    private final JWTManager jwtManager;

    public JWTFilter(JWTManager jwtManager) {
        this.jwtManager = jwtManager;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String auth = request.getHeader(HttpHeaders.AUTHORIZATION);

        // 회원가입이나 로그인이 되지 않았으면 로그인 요청해라
//        if (request.getRequestURI().contains("freeboard")
//                || request.getRequestURI().contains("login")) {
//            return;
//        }

        // jwt 가 넘어오지 않으면 로그인 처리 안 함
        if (auth == null || !auth.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }
        // jwt 넘어오면 로그인 처리
        else {
            try {
                String token = auth.split(" ")[1];
                // token 유효성 검사 후 해당 email, role 가져옴
                Jws<Claims> claims = jwtManager.getClaims(token);
                String email = claims.getPayload().get("email").toString();
                String role = claims.getPayload().get("role").toString();
                LoginUserDetails loginUserDetails = new LoginUserDetails(email, null, role);
                Authentication authentication = new UsernamePasswordAuthenticationToken(
                        loginUserDetails, null, loginUserDetails.getAuthorities()
                );
                // login setting
                SecurityContextHolder.getContext().setAuthentication(authentication);
            } catch (Exception e) {
//                throw new AuthException(e.getMessage());
//                System.out.println(e.getMessage());
            }
            filterChain.doFilter(request, response);
        }
    }
}