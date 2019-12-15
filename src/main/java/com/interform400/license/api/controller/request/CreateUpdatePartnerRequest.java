package com.interform400.license.api.controller.request;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
@SuppressWarnings("unused")
public class CreateUpdatePartnerRequest {

    private String companyName;


    public CreateUpdatePartnerRequest() {
    }

    public CreateUpdatePartnerRequest(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
