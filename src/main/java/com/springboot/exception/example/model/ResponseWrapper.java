package com.springboot.exception.example.model;

import lombok.Data;

import java.util.Map;

@Data
public class ResponseWrapper {
    private Integer statusCode;
    private String message;
    private Map<String, Object> validation;


    public ResponseWrapper(Integer statusCode, String message, Map<String, Object> validation) {
        this.statusCode = statusCode;
        this.message = message;
        this.validation = validation;
    }
}
