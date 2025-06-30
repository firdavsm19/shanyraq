package com.Firdavs.Shanyraq.user_service.exceptions;

public class InvalidConfirmationException extends RuntimeException{
    public InvalidConfirmationException(){
        super("Invalid confirmation code");
    }
}
