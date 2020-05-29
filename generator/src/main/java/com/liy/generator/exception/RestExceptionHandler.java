package com.liy.generator.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Locale;

@ControllerAdvice
public class RestExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(value = CustExpection.class)
    @ResponseBody
    public ResponseEntity<ErrorResponse> handleBadRequestException( CustExpection custExpection, Locale locale ) {
        String message = messageSource.getMessage(custExpection.getMsg(), custExpection.getList(), locale);
        ErrorResponse errorResponse = new ErrorResponse(message);
        return new ResponseEntity<>(errorResponse, HttpStatus.FORBIDDEN);
    }
}
