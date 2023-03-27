package com.anuraagkb.propertymanagement.errors;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ErrorModel {

    private HttpStatus status;
    private String errorMessage;

    public ErrorModel(HttpStatus status, String errorMessage) {
        this.status = status;
        this.errorMessage = errorMessage;
    }
}
