package com.Firdavs.Shanyraq.user_service.exceptions;

public class UserNotVerifiedException extends RuntimeException {
    public UserNotVerifiedException(String email){
        super("User with email " + email + " is not verified");
    }
}
