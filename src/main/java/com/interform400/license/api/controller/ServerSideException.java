package com.interform400.license.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
class ServerSideException extends RuntimeException {

    ServerSideException(String message) {
        super(message);
    }
}
