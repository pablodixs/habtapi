package com.habitine.developers.habtapi.infra;

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
