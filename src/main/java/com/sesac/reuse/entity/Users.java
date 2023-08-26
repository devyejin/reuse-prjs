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
@Table(name="user")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String email;
    private String pw;
    private String nickname;

//    private boolean del; <- 회원탈퇴기능 구현여부따라

    @Enumerated(EnumType.STRING)
    private SocialSignUpInfo social; // JPA의 경우 Optional을 미지원함

}
