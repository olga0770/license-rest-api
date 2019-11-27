package com.interform400.license.api.controller;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class CreateUserRequest {

    private final String username;
    private final Long partnerId;

    public CreateUserRequest(String username, Long partnerId) {
        this.username = username;
        this.partnerId = partnerId;
    }

    String getUsername() {
        return username;
    }

    Long getPartnerId() {
        return partnerId;
    }

}
