package com.kbl.kundgolservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.ALREADY_REPORTED)
public class ResourceAlreadyExistExcepton extends Exception{

    private static final long serialVersionUID = 1L;
    public ResourceAlreadyExistExcepton(String message){
        super(message);
    }
}
