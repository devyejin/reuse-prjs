package com.sesac.reuse.config.security.dto;

import com.sesac.reuse.entity.SocialSignUpInfo;
import com.sesac.reuse.entity.UsersRole;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Getter
@Setter
@ToString
public class CustomUserDetails extends User { //UserDetails 인터페이스를 구현한 User 클래스 상속

    private Long userId;
    private String email;
    private String pw;
    private String nickname;
    private SocialSignUpInfo social;
    private UsersRole role;


    public CustomUserDetails(String username, String password
                             ,Long userId, String nickname,
                             SocialSignUpInfo social,
                             Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);

        this.email = username;
        this.pw = password;
        this.userId = userId;
        this.nickname = nickname;
        this.social = social;


    }
}
