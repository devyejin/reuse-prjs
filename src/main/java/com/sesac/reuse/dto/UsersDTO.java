package com.sesac.reuse.dto;

import com.sesac.reuse.entity.SocialSignUpInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UsersDTO {

    private Long userId;
    private String email;
    private String pw;
    private String confirmPw;
    private String nickname;
    private SocialSignUpInfo social;

}
