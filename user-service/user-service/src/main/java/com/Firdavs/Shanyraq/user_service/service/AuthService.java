package com.Firdavs.Shanyraq.user_service.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.Firdavs.Shanyraq.user_service.dto.LoginRequest;
import com.Firdavs.Shanyraq.user_service.dto.LoginResponse;
import com.Firdavs.Shanyraq.user_service.dto.RegisterRequest;
import com.Firdavs.Shanyraq.user_service.dto.RegisterResponse;
import com.Firdavs.Shanyraq.user_service.dto.UserDto;
import com.Firdavs.Shanyraq.user_service.model.User;
import com.Firdavs.Shanyraq.user_service.model.UserAuth;
import com.Firdavs.Shanyraq.user_service.repository.UserRepository;
import com.Firdavs.Shanyraq.user_service.service.utility.CodeGeneratorService;
import com.Firdavs.Shanyraq.user_service.repository.SessionRepository;
import com.Firdavs.Shanyraq.user_service.model.Session;
import com.Firdavs.Shanyraq.user_service.service.utility.TokenService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordService passwordService;
    private final CodeGeneratorService codeGeneratorService;
    private final SessionRepository sessionRepository;
    private final TokenService tokenService;
    // Register a new user
    public RegisterResponse register(RegisterRequest request){
        LocalDateTime timestamp = LocalDateTime.now();
       
        User user = User.builder()
        .firstName(request.getFirstName())
        .lastName(request.getLastName())
        .email(request.getEmail())
        .phoneNumber(request.getPhoneNumber())
        .createdAt(timestamp)
        .updatedAt(timestamp)
        .build();

        UserAuth userAuth = UserAuth.builder()
        .user(user)
        .password(passwordService.hashPassword(request.getPassword()))
        .confirmationCode(codeGeneratorService.generateConfirmationCode())
        .isVerified(false)
        .build();

        user.setUserAuth(userAuth);
        userAuth.setUser(user);

        userRepository.save(user);



        return RegisterResponse.builder()
        .success(true)
        .user(mapToUserDto(user, userAuth))
        .message("User registered successfully")
        .timestamp(timestamp)
        .build();
    }

    // Login a user
    public LoginResponse login(LoginRequest request){
        User user = userRepository.findByEmail(request.getEmail()).orElseThrow(() -> new RuntimeException("User not found"));
        UserAuth userAuth = user.getUserAuth();

        if(!passwordService.matches(request.getPassword(), userAuth.getPassword())){
            throw new RuntimeException("Invalid password");
        }

        // if(!userAuth.isVerified()){
        //     throw new RuntimeException("User is not verified");
        // }

        Session session = Session.builder()
        .user(user)
        .accessToken(tokenService.generateAccessToken(user))
        .refreshToken(tokenService.generateRefreshToken(user))
        .build();
        sessionRepository.save(session);


        return LoginResponse.builder()
        .success(true)
        .user(mapToUserDto(user, userAuth))
        .message("User logged in successfully")
        .accessToken(session.getAccessToken())
        .refreshToken(session.getRefreshToken())
        .timestamp(LocalDateTime.now())
        .build();
    }

    public UserDto mapToUserDto(User user, UserAuth userAuth){
        return UserDto.builder()
        .id(user.getId())
        .firstName(user.getFirstName())
        .lastName(user.getLastName())
        .email(user.getEmail())
        .phoneNumber(user.getPhoneNumber())
        .isVerified(userAuth.isVerified())
        .build();
    }
}
