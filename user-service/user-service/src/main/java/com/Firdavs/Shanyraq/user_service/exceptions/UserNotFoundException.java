package com.Firdavs.Shanyraq.user_service.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String email){
        super("User with email " + email + " not found");
    }

    public UserNotFoundException(Long id){
        super("User with id " + id + " not found");
    }
    
}
