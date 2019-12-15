package com.interform400.license.api.controller.request;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
@SuppressWarnings("unused")
public class CreateUpdatePartnerRequest {

    private String companyName;
    private String address;
    private String zip;
    private String city;
    private String country;


    public CreateUpdatePartnerRequest() {
    }

    public CreateUpdatePartnerRequest(String companyName, String address, String zip, String city, String country) {

        this.companyName = companyName;
        this.address = address;
        this.zip = zip;
        this.city = city;
        this.country = country;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
