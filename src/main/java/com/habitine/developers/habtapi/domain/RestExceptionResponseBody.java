package com.habitine.developers.habtapi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class RestExceptionResponseBody {
    private Integer status;
    private String message;
}
