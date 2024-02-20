package com.habitine.developers.habtapi.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestExceptionResponseWithDescription extends RestExceptionResponseBody {
    private String description;

    public RestExceptionResponseWithDescription(Integer status, String message, String description) {
        super(status, message);
        this.description = description;
    }
}
