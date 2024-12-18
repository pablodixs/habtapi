package com.habitine.developers.habtapi.domain;

import com.habitine.developers.habtapi.modules.habits.exceptions.MissingUserException;
import com.habitine.developers.habtapi.modules.user.exceptions.InvalidUserIdException;
import com.habitine.developers.habtapi.modules.user.exceptions.UserAlreadyExistsException;
import com.habitine.developers.habtapi.modules.user.exceptions.UserNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionsHandler extends ResponseEntityExceptionHandler {

    // @Override
    // protected ResponseEntity<RestExceptionResponseBody>
    // handleMethodArgumentNotValid(
    // MethodArgumentNotValidException exception,
    // HttpHeaders headers,
    // HttpStatus status,
    // WebRequest request) {

    // BindingResult result = exception.getBindingResult();
    // List<FieldError> fieldErrors = result.getFieldErrors();

    // StringBuilder message = new StringBuilder("The following field cannot be
    // null: ");

    // for (FieldError fieldError : fieldErrors) {
    // message.append(fieldError.getField());
    // }

    // RestExceptionResponseBody body = new RestExceptionResponseBody(
    // HttpStatus.BAD_REQUEST.value(),
    // message.toString());

    // return ResponseEntity.badRequest().body(body);
    // }

    @ResponseBody
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<RestExceptionResponseBody> userNotFoundHandler(UserNotFoundException exception) {
        RestExceptionResponseBody body = new RestExceptionResponseBody(
                HttpStatus.NOT_FOUND.value(),
                exception.getMessage());

        return ResponseEntity.status(body.getStatus()).body(body);
    }

    @ResponseBody
    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<RestExceptionResponseBody> userAlreadyExistsHandler(UserAlreadyExistsException exception) {
        RestExceptionResponseBody body = new RestExceptionResponseBody(
                HttpStatus.BAD_REQUEST.value(),
                exception.getMessage());

        return ResponseEntity.status(body.getStatus()).body(body);
    }

    @ResponseBody
    @ExceptionHandler(MissingUserException.class)
    public ResponseEntity<RestExceptionResponseWithDescription> missingUserWhenCreatingHabit(MissingUserException exception) {
        RestExceptionResponseWithDescription body = new RestExceptionResponseWithDescription(
                HttpStatus.BAD_REQUEST.value(),
                exception.getMessage(),
                exception.getDescription()
        );

        return ResponseEntity.status(body.getStatus()).body(body);
    }

    @ResponseBody
    @ExceptionHandler(InvalidUserIdException.class)
    public ResponseEntity<RestExceptionResponseBody> missingUserWhenCreatingHabit(InvalidUserIdException exception) {
        RestExceptionResponseBody body = new RestExceptionResponseBody(
                HttpStatus.BAD_REQUEST.value(),
                exception.getMessage()
        );

        return ResponseEntity.status(body.getStatus()).body(body);
    }
}
