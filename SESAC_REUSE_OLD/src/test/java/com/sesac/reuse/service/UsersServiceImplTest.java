package com.sesac.reuse.service;

import com.sesac.reuse.dto.UsersDTO;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Log4j2
class UsersServiceImplTest {

    @Autowired
    UsersService usersService;

    @Test
    void joinTest() {
        //given
        UsersDTO testUserDTO = UsersDTO.builder()
                .email("test3@naver.com")
                .pw("password")
                .nickname("테스트회원")
                .build();

        //when
        usersService.join(testUserDTO);

        //then

    }

}