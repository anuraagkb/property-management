package com.anuraagkb.propertymanagement.errors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.NativeWebRequest;

@ControllerAdvice
public class PropertyExceptionHandler {
    @ExceptionHandler(PropertyException.class)
    public ResponseEntity<ErrorModel> PropertyHandler(PropertyException exception, NativeWebRequest request){
        return new ResponseEntity<ErrorModel>(exception.getErrorModel(), exception.getErrorModel().getStatus());
    }

}
