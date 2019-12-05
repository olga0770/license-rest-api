package com.interform400.license.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ServerSideException extends RuntimeException {

    public ServerSideException(String message) {
        super(message);
    }
}
