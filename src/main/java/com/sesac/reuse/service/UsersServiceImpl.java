package com.sesac.reuse.service;

import com.sesac.reuse.dto.UsersDTO;
import com.sesac.reuse.entity.SocialSignUpInfo;
import com.sesac.reuse.entity.Users;
import com.sesac.reuse.entity.UsersRole;
import com.sesac.reuse.exception.UsersExistException;
import com.sesac.reuse.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService{

    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    @Override
    public void join(UsersDTO usersDTO) {

        //가입하려는 이메일 중복 체크
        boolean isExist = usersRepository.existsByEmail(usersDTO.getEmail());

        if(isExist) {
            log.error("이미 가입하신 계정입니다.");
            throw new UsersExistException();
        }

        //없는 경우
        Users users = modelMapper.map(usersDTO, Users.class);
        users.changePw(passwordEncoder.encode(usersDTO.getPw()));
        users.addRole(UsersRole.USER);
        users.setSocial(SocialSignUpInfo.NULL);

        log.info("users={}", users);
        usersRepository.save(users);

    }
}
