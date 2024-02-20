package com.habitine.developers.habtapi.modules.user.exceptions;

public class InvalidUserIdException extends IllegalArgumentException {
    public InvalidUserIdException() {
        super("The Id provided is wrong or is not compatible.");
    }

    public InvalidUserIdException(String message) {
        super(message);
    }
}
