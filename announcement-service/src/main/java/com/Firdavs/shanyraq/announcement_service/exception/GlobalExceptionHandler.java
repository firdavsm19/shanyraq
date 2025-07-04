package com.Firdavs.shanyraq.announcement_service.exception;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;


import com.Firdavs.shanyraq.announcement_service.dto.ErrorReponseDto;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ErrorReponseDto> handleValidationException(ValidationException e, WebRequest request){
        ErrorReponseDto errorResponse = ErrorReponseDto.builder()
            .errorCode("VALIDATION_ERROR")
            .message(e.getMessage())
            .details(e.getMessage())
            .timestamp(LocalDateTime.now())
            .path(request.getDescription(false))
            .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }   
}
