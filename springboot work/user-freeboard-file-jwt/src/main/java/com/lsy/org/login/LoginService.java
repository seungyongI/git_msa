package com.lsy.org.login;

import com.lsy.org.user.User;
import com.lsy.org.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoginService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    // 회원가입
    public void join(JoinDto joinDto) {
        User user = modelMapper.map(joinDto, User.class);
        // 암호화...
        user.setPassword(
                passwordEncoder.encode(joinDto.getPassword())
        );
        user.setRole("ROLE_ADMIN");
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // 해당되는 이메일이 있는지 DB 에서 확인
        // 없으면 throw 해서 UserNameNotFoundException 실행
        User user = userRepository.findByEmail(username).orElseThrow(
                () -> new UsernameNotFoundException(username)
        );

        // password 1234 이면 ADMIN 로그인
        // username 아무거나 상관 X
        return org.springframework.security.core.userdetails
                .User
                .builder()
                .username(user.getEmail())
                .password(user.getPassword())
//                .password(passwordEncoder.encode("1234"))
                .roles("ADMIN")
                .build();
    }
}
