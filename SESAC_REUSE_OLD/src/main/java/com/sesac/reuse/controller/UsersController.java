package com.sesac.reuse.controller;

import com.sesac.reuse.dto.UsersDTO;
import com.sesac.reuse.exception.UsersExistException;
import com.sesac.reuse.service.UsersService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/user")
public class UsersController {

    private final UsersService usersService;

    @GetMapping("/signup")
    public void signUp() {

    }

    @PostMapping("/signup")
    public String signUp(@Valid UsersDTO usersDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        log.info("회원가입 호출");
        log.info("usersDTO={}",usersDTO);

        if(bindingResult.hasErrors()) {
            log.error("bindingResult={}",bindingResult.toString());
            return "/user/signup";
        }

        //비번검증
        if(!usersDTO.getPw().equals(usersDTO.getConfirmPw())) {
            bindingResult.rejectValue("pw","passwordInCorrect","비밀번호와 확인 비밀번호가 일치하지 않습니다.");
            log.error("bindingResult.rejectValue error occur");
            return "/user/signup";
        }

        try {
            usersService.join(usersDTO);
        }catch (UsersExistException e) {
            return "redirect:/user/signup"; //화면단에 출력해줄 코드 필요!
        }catch (Exception e) {
            log.error(e.getMessage());
        }

        //정상 가입시
        redirectAttributes.addFlashAttribute("result", "success");
        return "redirect:/user/login";

    }

    @GetMapping("/login")
    public void login() {

    }






    @GetMapping("/mypage")
    public String myPage() {

        return "my_page";
    }
}
