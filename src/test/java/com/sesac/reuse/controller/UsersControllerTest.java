package com.sesac.reuse.controller;

import com.sesac.reuse.dto.UsersDTO;
import com.sesac.reuse.entity.SocialSignUpInfo;
import com.sesac.reuse.entity.Users;
import com.sesac.reuse.service.UsersService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;

@Log4j2
@WebMvcTest(UsersController.class)
class UsersControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UsersService usersService;

    @Test
    public void signupSuccessValidation() throws Exception {
        //given
        mockMvc.perform(MockMvcRequestBuilders.post("/user/signup")
                        .with(csrf()) //include csrf token
                        .param("email","test5@naver.com")
                        .param("pw","1234")
                        .param("confirmPw","1234")
                        .param("nickname","testUser"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/users/login"));

    }

//    @Test
//    public void testSignUpValidation() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.post("/user/signup")
//                        .param("email", "invalidEmail")
//                        .param("pw", "password")
//                        .param("confirmPw", "differentPassword"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.model().hasErrors())
//                .andExpect(MockMvcResultMatchers.view().name("/user/signup"));
//    }

}