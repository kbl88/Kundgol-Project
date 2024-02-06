package com.kbl.kundgolservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class FieldIsMandatoryException extends Exception{

    private static final long serialVersionUID = 1L;
    public FieldIsMandatoryException(String message){
        super(message);
    }
}