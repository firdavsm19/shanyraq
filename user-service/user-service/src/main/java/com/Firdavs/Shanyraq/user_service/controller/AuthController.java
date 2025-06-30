package com.Firdavs.Shanyraq.user_service.controller;

import com.Firdavs.Shanyraq.user_service.dto.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import jakarta.validation.Valid;
import com.Firdavs.Shanyraq.user_service.service.AuthService;

import java.rmi.MarshalledObject;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    
    // POST /api/auth/login
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request){
        return ResponseEntity.ok(authService.login(request));
    }
    // POST /api/auth/register
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<RegisterResponse> register(@RequestBody @Valid RegisterRequest request){
        return ResponseEntity.ok(authService.register(request));
    }

    // POST /api/auth/logout
    @PostMapping("/logout")
    public ResponseEntity<Map<String, String>> logout(@RequestHeader("Authorization") String header){
        String accessToken = header.replace("Bearer ", "");
        return ResponseEntity.ok(authService.logout(accessToken));
    }

    // POST /api/auth/verify
    @PostMapping("/verify")
    public ResponseEntity<Map<String, String>> verify(@RequestBody VerifyRequest request){
        return ResponseEntity.ok(authService.verify(request));
    }

    // POST /api/auth/google

    // Post api/auth/refresh
    @PostMapping("/refresh")
    public ResponseEntity<LoginResponse> refresh(@RequestBody RefreshRequest request){
        return ResponseEntity.ok(authService.refresh(request));
    }

    // GET /api/auth/me
    @GetMapping("/me")
    public ResponseEntity<UserDto> getMe() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userId = authentication.getName();
        UserDto userDto = authService.getMe(Long.parseLong(userId));
        return ResponseEntity.ok(userDto);
    }


   // POST /api/auth/resend-verification
    
}
