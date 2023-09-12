package com.sesac.reuse.entity;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String email;
    private String pw;
    private String nickname;

    @Enumerated(EnumType.STRING)
    private UsersRole role;

//    private boolean del; <- 회원탈퇴기능 구현여부따라

    @Enumerated(EnumType.STRING)
    private SocialSignUpInfo social; // JPA의 경우 Optional을 미지원함

    public void changePw(String pw) {
        this.pw = pw;
    }

    public void addRole(UsersRole role) {
        this.role = role;
    }

    public void setSocial(SocialSignUpInfo social) {
        this.social = social;
    }
}
