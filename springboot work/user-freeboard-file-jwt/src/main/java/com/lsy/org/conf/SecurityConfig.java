package com.lsy.org.conf;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

//    private final AuthenticationConfiguration authenticationConfiguration;
//    private final JWTManager jwtManager;

//    public SecurityConfig(AuthenticationConfiguration authenticationConfiguration) {
//        this.authenticationConfiguration = authenticationConfiguration;
//    }

    // spring session -> loadByUserName attemptAuthentication
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
//        return configuration.getAuthenticationManager();
//    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(csrf -> csrf.disable());
        http.formLogin(form -> form.disable());
        http.httpBasic(basic -> basic.disable());

        http.authorizeRequests(auth -> auth.requestMatchers("/**").permitAll());
        // 일반 사용자도 접근 가능하다
//                .requestMatchers("/", "/login", "/join", "/freeboard/**", "/user/**", "/file/**").permitAll()
        // swagger 문서와 h2-console 접속 가능하게..
//                .requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll()
//                .requestMatchers("/test/**").permitAll()
        // AMDIN 으로 role 을 가지고 있을때 접근 가능 하다.
//                .requestMatchers("/admin").hasRole("ADMIN")
//                .anyRequest().authenticated());

        // JWTFilter JWT 토큰 검사
//        http.addFilterBefore(new JWTFilter(jwtManager), LoginFilter.class);
        // UsernamePasswordAuthenticationFilter -> LoginFilter
        // Login 요청 들어오면 email, password 비교 후 jwt 검사
//        http.addFilterAt(new LoginFilter(
//                        authenticationManager(authenticationConfiguration),
//                        jwtManager
//                ),
//                UsernamePasswordAuthenticationFilter.class);

        http.sessionManagement( session -> session.sessionCreationPolicy( SessionCreationPolicy.STATELESS ));
        return http.build();
    }
}
