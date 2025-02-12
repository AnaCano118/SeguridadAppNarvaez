package com.canoAna.Errores.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UnauthorizedException extends AppException {
    public UnauthorizedException(String message) {
        super(message);
    }
}