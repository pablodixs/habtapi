package com.habitine.developers.habtapi.infra;

import com.habitine.developers.habtapi.modules.user.exceptions.UserAlreadyExistsException;
import com.habitine.developers.habtapi.modules.user.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionsHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    private ResponseEntity<RestExceptionResponseBody> userNotFoundHandler(UserNotFoundException exception) {
        RestExceptionResponseBody body = new RestExceptionResponseBody(
                HttpStatus.NOT_FOUND,
                HttpStatus.NOT_FOUND.value(),
                exception.getMessage());

        return ResponseEntity.status(body.getStatus()).body(body);
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    private ResponseEntity<RestExceptionResponseBody> userAlreadyExistsHandler(UserAlreadyExistsException exception) {
        RestExceptionResponseBody body = new RestExceptionResponseBody(
                HttpStatus.BAD_REQUEST,
                HttpStatus.BAD_REQUEST.value(),
                exception.getMessage());

        return ResponseEntity.status(body.getStatus()).body(body);
    }
}
