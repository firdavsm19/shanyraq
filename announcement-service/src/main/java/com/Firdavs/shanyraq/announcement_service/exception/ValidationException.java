package com.Firdavs.shanyraq.announcement_service.exception;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValidationException extends RuntimeException {
    private String message;
}
