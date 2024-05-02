package com.example.demo.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserLoginServiceImpl implements UserLoginService {

    @Value("${SECRET-KEY}")
    private String secretKey;

    @Override
    public String generateToken(String email) {
        
        long expirationTime = System.currentTimeMillis() + (24 * 60 * 60 * 1000);

        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(SignatureAlgorithm.HS256,secretKey)
                .compact();
    }
}
