package com.Firdavs.Shanyraq.user_service.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Firdavs.Shanyraq.user_service.dto.LoginRequest;
import com.Firdavs.Shanyraq.user_service.dto.LoginResponse;
import com.Firdavs.Shanyraq.user_service.dto.RegisterRequest;
import com.Firdavs.Shanyraq.user_service.dto.RegisterResponse;
import lombok.RequiredArgsConstructor;
import jakarta.validation.Valid;
import com.Firdavs.Shanyraq.user_service.service.AuthService;

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
    
    
    
    // POST /api/auth/verify
    
    
    
    // POST /api/auth/google

    // Post api/auth/refresh


    // GET /api/auth/me

   // POST /api/auth/resend-verification
    
}
