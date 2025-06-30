package com.Firdavs.Shanyraq.user_service.exceptions;

public class TokenExpiredException extends RuntimeException {
    public TokenExpiredException(String message){
        super(message);
    }
}
