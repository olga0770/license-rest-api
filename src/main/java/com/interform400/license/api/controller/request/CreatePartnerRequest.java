package com.interform400.license.api.controller.request;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class CreatePartnerRequest {

    private final String companyName;


    public CreatePartnerRequest(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }
}
