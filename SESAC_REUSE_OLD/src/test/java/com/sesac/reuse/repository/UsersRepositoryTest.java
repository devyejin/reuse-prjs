package com.sesac.reuse.repository;

import com.sesac.reuse.entity.SocialSignUpInfo;
import com.sesac.reuse.entity.Users;
import lombok.extern.log4j.Log4j2;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest
@Log4j2
class UsersRepositoryTest {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Test
    void signupTest() {
        //given
        Users newUser = Users.builder()
                .email("test@naver.com")
                .pw(passwordEncoder.encode("password"))
                .nickname("yesorno")
                .social(SocialSignUpInfo.NULL)
                .build();

        //when
        usersRepository.save(newUser);

        //then
        Users findUser = usersRepository.findById(newUser.getUserId()).orElseThrow();
        Assertions.assertThat(newUser.getUserId()).isEqualTo(findUser.getUserId());

        log.info("findUser={}", findUser);
    }

    @Test
    void findUsersByEmail() {
        //given
        Users newUser = Users.builder()
                .email("test@naver.com")
                .pw(passwordEncoder.encode("password"))
                .nickname("yesorno")
                .social(SocialSignUpInfo.NULL)
                .build();

        //when
        Users findUser = usersRepository.findByEmail(newUser.getEmail());

        //then
        Assertions.assertThat(newUser.getEmail()).isEqualTo(findUser.getEmail());
    }

    @Test
    void isExistByEmail() {
        //given
        Users newUser = Users.builder()
                .email("test@naver.com")
                .pw(passwordEncoder.encode("password"))
                .nickname("yesorno")
                .social(SocialSignUpInfo.NULL)
                .build();

        //when
        boolean isExist = usersRepository.existsByEmail(newUser.getEmail());

        //then
        Assertions.assertThat(isExist).isEqualTo(true);
    }

}