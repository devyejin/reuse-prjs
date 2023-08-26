package com.sesac.reuse.dto;

import com.sesac.reuse.entity.SocialSignUpInfo;
import lombok.Getter;

@Getter
public class UsersDTO {

    private Long userId;
    private String email;
    private String pw;
    private String nickname;
    private SocialSignUpInfo social;

}
