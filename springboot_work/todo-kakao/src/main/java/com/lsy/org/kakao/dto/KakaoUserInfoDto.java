package com.lsy.org.kakao.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class KakaoUserInfoDto {
    private Long id;
    @JsonProperty(value = "connected_at")
    private String connectedAt;
    @JsonProperty(value = "properties")
    private Properties properties;
    @JsonProperty(value = "kakao_account")
    private KakaoAccount kakaoAccount;

    @Data
    @ToString
    public static class Properties {
        @JsonProperty(value = "nickname")
        private String nickname;
        @JsonProperty(value = "profile_image")
        private String profileImage;
        @JsonProperty(value = "thumbnail_image")
        private String thumbnailImage;
    }

    @Data
    @ToString
    public static class KakaoAccount {
        @JsonProperty(value = "profile")
        private Profile profile;
        @JsonProperty(value = "email")
        private String email;

        @Data
        @ToString
        public static class Profile {
            @JsonProperty(value = "nickname")
            private String nickname;
            @JsonProperty(value = "thumbnail_image_url")
            private String thumbnailImageUrl;
            @JsonProperty(value = "profile_image_url")
            private String profileImageUrl;
        }
    }
}

