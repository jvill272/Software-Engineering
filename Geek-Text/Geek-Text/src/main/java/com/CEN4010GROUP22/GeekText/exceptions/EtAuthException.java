package com.CEN4010GROUP22.GeekText.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class EtAuthException extends RuntimeException {

    public EtAuthException(String message) {
        super(message);
    }
}