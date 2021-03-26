package com.mejdeddine.springSecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        //le crypteur le plus populaire de tous les crypteur. 10 est la force de chiffrage
        return new BCryptPasswordEncoder(10);
    }
}
