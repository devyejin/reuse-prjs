package com.sesac.reuse.dto;

import com.sesac.reuse.entity.SocialSignUpInfo;
import com.sesac.reuse.entity.UsersRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UsersDTO {


    private Long userId;

    @Email @NotBlank
    private String email;
    @NotBlank
    private String pw;
    @NotBlank
    private String confirmPw;
    @NotBlank
    private String nickname;
    private SocialSignUpInfo social;
    private UsersRole role;

}
