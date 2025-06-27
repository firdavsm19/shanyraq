package com.Firdavs.Shanyraq.user_service.service.utility;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import com.Firdavs.Shanyraq.user_service.model.User;

@Service
public class TokenService {
    @Value("${secret.key}")
    private String secretKey;

    public String generateAccessToken(User user){
        return Jwts.builder()
        .setSubject(user.getId().toString())
        .setIssuedAt(new Date())
        .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
        .signWith(SignatureAlgorithm.HS256, secretKey)
        .compact();
    }

    public String generateRefreshToken(User user){
        return Jwts.builder()
        .setSubject(user.getId().toString())
        .setIssuedAt(new Date())
        .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 7))
        .signWith(SignatureAlgorithm.HS256, secretKey)
        .compact();
    }
}
