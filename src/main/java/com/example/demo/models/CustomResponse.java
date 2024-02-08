package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class CustomResponse<T> {
    private T object;
    private int status;
    private boolean error;
    private String message;
}
