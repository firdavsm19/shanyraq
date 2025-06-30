package com.Firdavs.Shanyraq.user_service.service;

import java.time.LocalDateTime;
import java.util.Map;

import com.Firdavs.Shanyraq.user_service.dto.*;
import com.Firdavs.Shanyraq.user_service.model.UserProfile;
import com.Firdavs.Shanyraq.user_service.repository.UserAuthRepository;
import org.springframework.stereotype.Service;

import com.Firdavs.Shanyraq.user_service.model.User;
import com.Firdavs.Shanyraq.user_service.model.UserAuth;
import com.Firdavs.Shanyraq.user_service.repository.UserRepository;
import com.Firdavs.Shanyraq.user_service.service.utility.CodeGeneratorService;
import com.Firdavs.Shanyraq.user_service.repository.SessionRepository;
import com.Firdavs.Shanyraq.user_service.model.Session;
import com.Firdavs.Shanyraq.user_service.service.utility.TokenService;
import com.Firdavs.Shanyraq.user_service.exceptions.InvalidCredentialException;
import com.Firdavs.Shanyraq.user_service.exceptions.UserNotFoundException;
import com.Firdavs.Shanyraq.user_service.exceptions.UserNotVerifiedException;
import com.Firdavs.Shanyraq.user_service.exceptions.InvalidConfirmationException;
import com.Firdavs.Shanyraq.user_service.exceptions.TokenExpiredException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordService passwordService;
    private final CodeGeneratorService codeGeneratorService;
    private final SessionRepository sessionRepository;
    private final TokenService tokenService;
    private final UserAuthRepository authRepository;
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

        UserProfile userProfile = UserProfile.builder().user(user).build();

        user.setUserAuth(userAuth);
        user.setUserProfile(userProfile);
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
        LocalDateTime now = LocalDateTime.now();
        User user = userRepository.findByEmail(request.getEmail()).orElseThrow(() -> new UserNotFoundException(request.getEmail()));
        UserAuth userAuth = user.getUserAuth();

        if(!passwordService.matches(request.getPassword(), userAuth.getPassword())){
            throw new InvalidCredentialException("Invalid password");
        }

        if(!userAuth.isVerified()){
            throw new UserNotVerifiedException("User is not verified");
        }

        Session session = Session.builder()
        .user(user)
        .accessToken(tokenService.generateAccessToken(user))
        .refreshToken(tokenService.generateRefreshToken(user)).revoked(false).createdAt(now)
                .lastActivityAt(now).expiresAt(now.plusDays(30))
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

    public Map<String, String> logout(String accessToken){
        Session session = sessionRepository.findByAccessToken(accessToken)
                .orElseThrow(() -> new InvalidCredentialException("Invalid or expired access token"));

        session.setRevoked(true);
        session.setLastActivityAt(LocalDateTime.now());
        sessionRepository.save(session);

        return Map.of("message", "Logout Successful");
    }

    public UserDto getMe(Long userId){
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));

        UserAuth userAuth = user.getUserAuth();

        return mapToUserDto(user, userAuth);
    }

    public Map<String, String> verify(VerifyRequest request){
        User user = userRepository.findByEmail(request.getEmail()).orElseThrow(() -> new UserNotFoundException(request.getEmail()));

        if(user.getUserAuth().isVerified()){
            throw new UserNotVerifiedException(request.getEmail());
        }

        if(!user.getUserAuth().getConfirmationCode().equals(request.getConfirmationCode())){
            throw new InvalidConfirmationException();
        }

        user.getUserAuth().setVerified(true);
        user.getUserAuth().setConfirmationCode(null);
        userRepository.save(user);

        return Map.of("message", "User is successfully verified");
    }
    
    public LoginResponse refresh(RefreshRequest request){
         Session session = sessionRepository.findByRefreshToken(request.getRefreshToken()).orElseThrow(() -> new RuntimeException("Session is not found"));

         if(session.isRevoked()) throw new TokenExpiredException("Token has been revoked");

         if(session.getExpiresAt().isBefore(LocalDateTime.now())) throw new TokenExpiredException("Token has been expired");

         if(!session.getUser().getUserAuth().isVerified()) throw new UserNotVerifiedException(session.getUser().getEmail());

         session.setAccessToken(tokenService.generateAccessToken(session.getUser()));
         session.setRefreshToken(tokenService.generateRefreshToken(session.getUser()));
         sessionRepository.save(session);

        return LoginResponse.builder()
                .success(true)
                .user(mapToUserDto(session.getUser(), session.getUser().getUserAuth()))
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
