package com.Firdavs.shanyraq.announcement_service.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorReponseDto {
    private String errorCode;
    private String message;
    private String details;
    private LocalDateTime timestamp;
    private String path;
}
