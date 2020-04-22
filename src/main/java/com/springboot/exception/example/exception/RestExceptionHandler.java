package com.springboot.exception.example.exception;

import com.springboot.exception.example.model.ResponseWrapper;
import com.springboot.exception.example.util.ErrorValidation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseWrapper> handleException(MethodArgumentNotValidException e) {
        ResponseWrapper response = new ResponseWrapper(HttpStatus.BAD_REQUEST.value(), "Parameters not valid", ErrorValidation.getErrors(e));
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<ResponseWrapper> handleException(RecordNotFoundException e) {
        ResponseWrapper response = new ResponseWrapper(HttpStatus.NOT_FOUND.value(), e.getMessage(), null);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(DuplicateRecordException.class)
    public ResponseEntity<ResponseWrapper> handleException(DuplicateRecordException e){
        ResponseWrapper response = new ResponseWrapper(HttpStatus.BAD_REQUEST.value(),e.getMessage(),null);
        return  new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }
}
