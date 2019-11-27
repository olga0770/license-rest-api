package com.interform400.license.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
class NotFoundException extends RuntimeException {

    NotFoundException(String entityName, String id) {
        super(entityName + " not found:" + id);
    }
}
