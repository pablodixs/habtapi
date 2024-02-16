package com.habitine.developers.habtapi.infra;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatusCode;

@AllArgsConstructor
@Setter
@Getter
public class RestExceptionResponseBody {
    private HttpStatusCode title;
    private int status;
    private String message;
}
