package com.Firdavs.Shanyraq.user_service.exceptions;

public class InvalidCredentialException extends RuntimeException {
    public InvalidCredentialException(String message){
        super(message);
    }
}
