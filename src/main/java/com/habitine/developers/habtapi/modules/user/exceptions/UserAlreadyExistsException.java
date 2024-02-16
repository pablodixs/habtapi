package com.habitine.developers.habtapi.modules.user.exceptions;

public class UserAlreadyExistsException extends RuntimeException{
    public UserAlreadyExistsException() {
        super("User with this username or email already exists.");
    }

    public UserAlreadyExistsException(String message) {
        super(message);
    }
}
