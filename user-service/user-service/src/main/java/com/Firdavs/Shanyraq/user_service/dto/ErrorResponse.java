package com.Firdavs.Shanyraq.user_service.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorResponse {
    private String errorCode;
    private String message;
    private String details;
    private LocalDateTime timestamp;
    private String path;
    
}