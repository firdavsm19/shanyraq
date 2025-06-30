package com.Firdavs.Shanyraq.user_service.service;

import com.Firdavs.Shanyraq.user_service.model.PasswordResetModel;
import com.Firdavs.Shanyraq.user_service.model.User;
import com.Firdavs.Shanyraq.user_service.repository.PasswordResetModelRepository;
import com.Firdavs.Shanyraq.user_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PasswordResetService {
    private final PasswordResetModelRepository passwordResetModelRepository;
    private final UserRepository userRepository;
    private final PasswordService passwordService;

    public Map<String, String> requestReset(String ip, String email){
        User user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User is not found"));

        String token = UUID.randomUUID().toString();
        LocalDateTime expiration = LocalDateTime.now().plusMinutes(15);

        PasswordResetModel passwordResetModel= new PasswordResetModel().builder()
                .user(user)
                .ipAddress(ip)
                .isUsed(false)
                .token(token)
                .expiresAt(expiration)
                .build();

        passwordResetModelRepository.save(passwordResetModel);

        return Map.of("message", "Reset link sent");
    }

    public Map<String, String> confirmToken(String token){
        PasswordResetModel model = passwordResetModelRepository.findByToken(token).orElseThrow(() -> new RuntimeException("Token is not found"));

        if(model.isUsed() || model.getExpiresAt().isBefore(LocalDateTime.now())){
            throw new RuntimeException("Token expired or already used");
        }

        return Map.of("message", "Token is valid");
    }

    public Map<String, String> changePassword(String token, String newPassword){
        PasswordResetModel model = passwordResetModelRepository.findByToken(token).orElseThrow(() -> new RuntimeException("Invalid token"));

        if(model.isUsed() || model.getExpiresAt().isBefore(LocalDateTime.now())){
            throw new RuntimeException("Token is expired or already used");
        }

        User user = model.getUser();
        user.getUserAuth().setPassword(passwordService.hashPassword(newPassword));
        model.setUsed(true);

        passwordResetModelRepository.save(model);
        userRepository.save(user);

        return Map.of("message", "The password was changed");
    }
}

