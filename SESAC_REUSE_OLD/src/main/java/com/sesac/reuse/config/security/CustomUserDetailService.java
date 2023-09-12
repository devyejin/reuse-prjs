package com.sesac.reuse.config.security;

import com.sesac.reuse.config.security.dto.CustomUserDetails;
import com.sesac.reuse.entity.Users;
import com.sesac.reuse.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
@Log4j2
public class CustomUserDetailService implements UserDetailsService {

    private final UsersRepository usersRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        log.info("호출됨");

        Users user = usersRepository.findByEmail(email);

        if(user == null) {
            throw new UsernameNotFoundException("존재하지 않는 회원입니다.");
        }

        //UserDetails 에 조회된 사용자 정보 담아 넘겨줘야함
        UserDetails customUserDetails = new CustomUserDetails(user.getEmail(), user.getPw(), user.getUserId(),
                user.getNickname(), user.getSocial(), Collections.singleton(new SimpleGrantedAuthority(user.getRole().toString())));

        log.info("customUserDetails={}",customUserDetails);

        return customUserDetails;
    }
}
