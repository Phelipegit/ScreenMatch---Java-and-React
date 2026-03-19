package com.phelipe.ScreenMatch.security.JWT;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtConfig {
    @Value("${jwt.secret}")
    private String secretKey;
    @Value("${jwt.expiration}")
    private Long expiration;

    @Bean
    public JwtService jwtService() {
        return new JwtService(secretKey,expiration);
    }
}
