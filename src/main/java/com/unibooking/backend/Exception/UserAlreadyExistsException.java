package com.unibooking.backend.Exception;

public class UserAlreadyExistsException extends Exception{

    public UserAlreadyExistsException(String message) {
        super(message);
    }
}
