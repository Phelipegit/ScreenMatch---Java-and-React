package com.phelipe.ScreenMatch.security.JWT;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.List;


public class JwtService {
    private String secretKey;
    private Long expiration;


    public JwtService(String secretKey, Long expiration) {
        this.secretKey = secretKey;
        this.expiration = expiration;
    }

    public JwtService() {

    }

    public String gerarToken(String email, List<String> roles) {
        return Jwts.builder()
                .subject(email)
                .claim("roles",roles)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(getSignKey())
                .compact();
    }

    public String getEmailDoToken(String token) {
        if(!tokenValido(token)) {
            return null;
        }
        return Jwts.parser().verifyWith(getSignKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

    public List<String> getRolesDoToken(String token) {
        return Jwts.parser().verifyWith(getSignKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .get("roles", List.class);
    }

    public boolean tokenValido(String token) {
        try {
            Jwts.parser().verifyWith(getSignKey()).build().parseSignedClaims(token);
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    private SecretKey getSignKey() {
        return Keys.hmacShaKeyFor(secretKey.getBytes());
    }
}
