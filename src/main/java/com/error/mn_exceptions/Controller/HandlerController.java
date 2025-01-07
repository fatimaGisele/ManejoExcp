package com.error.mn_exceptions.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
//import com.error.mn_exceptions.Models.MnError;

@RestControllerAdvice
public class HandlerController {
    
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<?> Div(Exception e){
        return ResponseEntity.internalServerError().body(e.getMessage());
    }
}
