package com.interform400.license.api.controller;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
@SuppressWarnings("unused")
public class UpdateUserRequest {

    private final String username;
    private final Long partnerId;

    public UpdateUserRequest(String username, Long partnerId) {
        this.username = username;
        this.partnerId = partnerId;
    }

    String getUsername() {
        return username;
    }

    public Long getPartnerId() {
        return partnerId;
    }
}
