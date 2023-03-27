package com.anuraagkb.propertymanagement.errors;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
public class PropertyException extends RuntimeException{

    private ErrorModel errorModel;

    public PropertyException(ErrorModel errorModel){
        this.errorModel = errorModel;
    }
}

