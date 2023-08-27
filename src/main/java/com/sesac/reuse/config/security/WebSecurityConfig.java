package com.sesac.reuse.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig {

     //빈에 특정 경로는 보완을, 보안을 적용안하는 경로를 정의
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

       http
//                .csrf((csrf) -> csrf.ignoringRequestMatchers("/no-csrf"))
                .authorizeHttpRequests(requests-> requests
                        .requestMatchers("/","/home","/index","/assets/**",
                                "/fonts/**","/js/**","/libs/**","/scss/**","/tasks/**").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                        .loginPage("/user/login").permitAll()
                        .defaultSuccessUrl("/index")
                )
                .logout((logout) -> logout.permitAll())
       ;

        return http.build();
    }


    @Bean // <--- 이게 필요한가?
    public WebSecurityCustomizer webSecurityCustomizer() {
        return web -> web.ignoring().requestMatchers("/**"); //static 폴더 하위 경로
    }

    @Bean //테스트용 사용자
    public UserDetailsService userDetailsService() {

        User.UserBuilder users = User.withDefaultPasswordEncoder();

        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();

        manager.createUser(users.username("user").password("password").roles("USER").build());
        manager.createUser(users.username("admin").password("password").roles("USER","ADMIN").build());
        return manager;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
