package com.lsy.org.service;

import com.lsy.org.kakao.dto.KakaoUserInfoDto;
import com.lsy.org.kakao.jpa.KakaoEntity;
import com.lsy.org.kakao.jpa.KakaoRepository;
import com.lsy.org.kakao.dto.KakaoTokenDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class KakaoService {

    private final KakaoRepository kakaoRepository;

    public void getToken(String code) {
        try {
            // start get token
            String url = "https://kauth.kakao.com/oauth/token";
            RestTemplate restTemplate = new RestTemplate();

            // header content
            MultiValueMap headers = new LinkedMultiValueMap();
            headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

            // body content
            MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
            body.add("grant_type", "authorization_code");
            body.add("client_id", "92c14392ecbb1aa7a1a9f2a2272e4d36");
            body.add("redirect_uri", "http://localhost:5173/oauth");
            body.add("code", code);
            body.add("client_secret", "LcApnEar4vLWxAS9jDPpcjqGoQhHAgg0");

            HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(body, headers);

            ResponseEntity<KakaoTokenDto> result = restTemplate.exchange(url,
                    HttpMethod.POST,
                    requestEntity,
                    KakaoTokenDto.class);
            log.info("result {}", result);
            KakaoTokenDto kakaoTokenDto = result.getBody();

            // start get user's info
//            url = "https://kapi.kakao.com/v2/user/me";
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Authorization", "Bearer " + kakaoTokenDto.getAccess_token());
            ResponseEntity<KakaoUserInfoDto> res = restTemplate.exchange("https://kapi.kakao.com/v2/user/me"
                    , HttpMethod.GET
                    , new HttpEntity<>(null, httpHeaders)
                    , KakaoUserInfoDto.class
            );
            System.out.println("KakaoUserInfoDto = " + res.getBody());
            KakaoUserInfoDto kakaoUserInfoDto = res.getBody();
            // end get user's info

            KakaoEntity kakaoEntity = new ModelMapper().map(kakaoTokenDto, KakaoEntity.class);
            kakaoEntity.setEmail(kakaoUserInfoDto.getKakaoAccount().getEmail());
            kakaoEntity.setNickName(kakaoUserInfoDto.getKakaoAccount().getProfile().getNickname());
            kakaoEntity.setProfileImage(kakaoUserInfoDto.getProperties().getProfileImage());
            kakaoEntity.setThumbnailImage(kakaoUserInfoDto.getProperties().getThumbnailImage());

            kakaoEntity.setUserId(UUID.randomUUID().toString());

            kakaoRepository.save(kakaoEntity);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void messageSend(String email, String message) {
        RestTemplate restTemplate = new RestTemplate();
        // 메시지 보내는 주소...
        String url = "https://kapi.kakao.com/v2/api/talk/memo/default/send";

        HttpHeaders headers2 = new HttpHeaders();
        headers2.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
//        headers2.add("Authorization", "Bearer " + accessToken);

        MultiValueMap<String, Object> body2 = new LinkedMultiValueMap<>();
        body2.add("template_object", String.format(messageString(), "aaa@naver.com"));

        HttpEntity<MultiValueMap<String, Object>> requestEntity2 = new HttpEntity<>(body2, headers2);

        ResponseEntity<String> result2 = restTemplate.exchange(url,
                HttpMethod.POST, requestEntity2, String.class);
        log.info("msg 카카옥 메시지 전송 성공....." + result2.toString());
    }

    public String messageString() {
        return "{\n" +
                "        \"object_type\": \"text\",\n" +
                "        \"text\": \"안녕하세요 %s 님 우리 페이지에 가입해 주셔서 감사합니다.\",\n" +
                "        \"link\": {\n" +
                "            \"web_url\": \"http://localhost:5173\",\n" +
                "            \"mobile_web_url\": \"http://localhost:5173\"\n" +
                "        },\n" +
                "        \"button_title\": \"바로 확인\"\n" +
                "    }";
    }
}
