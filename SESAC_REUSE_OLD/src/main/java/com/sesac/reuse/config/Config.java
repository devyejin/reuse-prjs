package com.sesac.reuse.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public ModelMapper getMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE) //접근 가능 수준을 private 필드까지로 허용
                .setMatchingStrategy(MatchingStrategies.LOOSE); //loose매칭 전략 -> 프로퍼티가 같거나, 비슷한 이름(대소문자, underbar 무시)

        return modelMapper;
    }
}
