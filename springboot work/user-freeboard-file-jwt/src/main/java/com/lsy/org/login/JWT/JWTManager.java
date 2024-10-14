package com.lsy.org.login.JWT;

import com.lsy.org.error.JwtAuthException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class JWTManager {

    private final Environment environment;

    // JWT 생성
    public String createJWT(String email, String role) {
        String secretkey = environment.getProperty("spring.jwt.secret");

        String jwt = Jwts
                .builder()
                .claim("email", email)
                .claim("role", role)
                .issuedAt(new Date(System.currentTimeMillis())) // 현재 시간
//                .expiration(new Date(System.currentTimeMillis() + 1000)) // 1초 유효함
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24)) // 1초*60*60*24 1일 유효함
                .signWith(SignatureAlgorithm.HS256,
                        Base64.getEncoder().encodeToString(secretkey.getBytes()))
                .compact();

        return jwt;
    }

    public Jws<Claims> getClaims(String jwt) {
        String secretkey = environment.getProperty("spring.jwt.secret");
        try {
            // 비밀번호 설정
            SecretKey secretKey
                    = new SecretKeySpec(secretkey.getBytes(),
                    Jwts.SIG.HS256.key().build().getAlgorithm());

            // 해당 비밀번호로 jwt 토큰 복호화 해서 claims 가져오기
            Jws<Claims> claims = Jwts.parser()
                    .verifyWith(secretKey)
                    .build()
                    .parseSignedClaims(jwt);

            // claims 안에서 email 값 가져오기
            claims.getPayload().get("email").toString();
            return claims;
        } catch (Exception e) {
            throw new JwtAuthException("JWT "+e.getMessage());
        }
    }
}