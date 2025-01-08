package com.error.mn_exceptions.Controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.error.mn_exceptions.Models.MnError;

@RestControllerAdvice
public class HandlerController {
    
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<MnError> Div(Exception e){
        MnError error = new MnError();
        error.setFecha(new Date());
        error.setError("error");
        error.setMsg(e.getMessage());
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        //return ResponseEntity.internalServerError().body(error);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(error);
    }

    @ExceptionHandler(NumberFormatException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> NumberFormatException(Exception e){
        Map<String, Object> error = new HashMap<>();
        error.put("date",new Date());
        error.put("error", "Formato incorrecto");
        error.put("msg", e.getMessage());
        error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        return error;
    }


    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<MnError> NotFound(NoHandlerFoundException e){
        MnError error = new MnError();
        error.setFecha(new Date());
        error.setMsg(e.getMessage());
        error.setError("Not Found");
        error.setStatus(HttpStatus.NOT_FOUND.value());

        return ResponseEntity.status(404).body(error);
    }

    @ExceptionHandler({NullPointerException.class, HttpMessageNotWritableException.class, 
        com.error.mn_exceptions.Exceptions.UserNotFoundException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> UserNotFoundException(Exception e){
        Map<String, Object> error = new HashMap<>();
        error.put("date",new Date());
        error.put("error", "Usuario inexistente/ rol inexistente");
        error.put("msg", e.getMessage());
        error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        return error;
    }
}
