package com.Firdavs.Shanyraq.user_service.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.Firdavs.Shanyraq.user_service.dto.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUserNotFoundException(UserNotFoundException ex, WebRequest request){
        ErrorResponse errorResponse = ErrorResponse.builder()
            .errorCode("USER_NOT_FOUND")
            .message(ex.getMessage())
            .details(request.getDescription(false))
            .timestamp(LocalDateTime.now())
            .path(request.getDescription(false))
            .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(InvalidCredentialException.class)
    public ResponseEntity<ErrorResponse> handleInvalidCredentials(InvalidCredentialException ex, WebRequest request){
        ErrorResponse errorResponse = ErrorResponse.builder()
            .errorCode("INVALID_CREDENTIALS")
            .message(ex.getMessage())
            .details(request.getDescription(false))
            .timestamp(LocalDateTime.now())
            .path(request.getDescription(false))
            .build();

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
    }

    @ExceptionHandler(TokenExpiredException.class)
    public ResponseEntity<ErrorResponse> handleTokenExpiredException(TokenExpiredException ex, WebRequest request){
        ErrorResponse errorResponse = ErrorResponse.builder()
            .errorCode("TOKEN_EXPIRED")
            .message(ex.getMessage())
            .details(request.getDescription(false))
            .timestamp(LocalDateTime.now())
            .path(request.getDescription(false))
            .build();

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
    }

    @ExceptionHandler(UserNotVerifiedException.class)
    public ResponseEntity<ErrorResponse> handleUserNotVerifiedException(UserNotVerifiedException ex, WebRequest request){
        ErrorResponse errorResponse = ErrorResponse.builder()
            .errorCode("USER_NOT_VERIFIED")
            .message(ex.getMessage())
            .details(request.getDescription(false))
            .timestamp(LocalDateTime.now())
            .path(request.getDescription(false))
            .build();

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
    }

    @ExceptionHandler(InvalidConfirmationException.class)
    public ResponseEntity<ErrorResponse> handleInvalidConfirmationException(InvalidConfirmationException ex, WebRequest request){
        ErrorResponse errorResponse = ErrorResponse.builder()
            .errorCode("INVALID_CONFIRMATION")
            .message(ex.getMessage())
            .details(request.getDescription(false))
            .timestamp(LocalDateTime.now())
            .path(request.getDescription(false))
            .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGlobalException(Exception ex, WebRequest request){
        ErrorResponse errorResponse = ErrorResponse.builder()
            .errorCode("INTERNAL_SERVER_ERROR")
            .message(ex.getMessage())
            .details(request.getDescription(false))
            .timestamp(LocalDateTime.now())
            .path(request.getDescription(false))
            .build();

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }   
}
