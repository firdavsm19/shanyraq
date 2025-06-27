package com.Firdavs.Shanyraq.user_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class PasswordService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    public String hashPassword(String password){
        return passwordEncoder.encode(password);
    }

    public boolean matches(String password, String hashedPassword){
        return passwordEncoder.matches(password, hashedPassword);
    }

}
