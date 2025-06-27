package com.Firdavs.Shanyraq.user_service.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterResponse {

    private boolean success;

    private UserDto user;

    private String message;
    
    private LocalDateTime timestamp;
    
}
