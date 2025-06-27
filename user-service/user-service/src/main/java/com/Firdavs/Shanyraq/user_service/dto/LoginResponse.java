package com.Firdavs.Shanyraq.user_service.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {
    
    private boolean success;

    private UserDto user;

    private String message;

    private String accessToken;

    private String refreshToken;

    private LocalDateTime timestamp;
}
