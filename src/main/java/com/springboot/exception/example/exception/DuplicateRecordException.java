package com.springboot.exception.example.exception;

public class DuplicateRecordException extends RuntimeException {
    public DuplicateRecordException(String message){
        super(message);
    }
}
