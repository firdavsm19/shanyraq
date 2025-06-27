package com.Firdavs.Shanyraq.user_service.service.utility;

import java.security.SecureRandom;

import org.springframework.stereotype.Service;

@Service
public class CodeGeneratorService {
    private final SecureRandom random = new SecureRandom();
    public String generateConfirmationCode(){
        return String.format("%06d", random.nextInt(1000000));
    }
}
