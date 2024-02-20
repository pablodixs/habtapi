package com.habitine.developers.habtapi.modules.habits.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MissingUserException extends RuntimeException {
    private String description;

    public MissingUserException(String message, String description) {
        super(message);
        this.description = description;
    }

    public MissingUserException() {
        super("Missing user.");
        this.description = "An user is required to create a habit.";
    }
}
