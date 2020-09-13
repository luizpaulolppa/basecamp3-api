package com.basecamp3api.exception;

import com.basecamp3api.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlingController {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorDTO> businessExceptionHandling(BusinessException businessException) {
        return new ResponseEntity<ErrorDTO>(businessException.getErrors(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity exceptionHandling() {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
