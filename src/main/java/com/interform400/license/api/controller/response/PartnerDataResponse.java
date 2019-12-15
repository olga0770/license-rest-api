package com.interform400.license.api.controller.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.interform400.license.api.service.data.PartnerData;
import com.interform400.license.api.service.data.UserData;

import java.util.ArrayList;
import java.util.List;

/**
 * Partner data response, used for JSON responses.
 */
@JsonSerialize
@SuppressWarnings("unused")
public class PartnerDataResponse {

    private Long id;
    private String companyName;
    private String address;
    private String zip;
    private String city;
    private String country;
    private List<UserDataResponse> users;

    public PartnerDataResponse(PartnerData partnerData) {
        this.id = partnerData.getId();
        this.companyName = partnerData.getCompanyName();
        this.address = partnerData.getAddress();
        this.zip = partnerData.getZip();
        this.city = partnerData.getCity();
        this.country = partnerData.getCountry();

        this.users = new ArrayList<>();
        for (UserData userData: partnerData.getUsers()) {
            this.users.add(new UserDataResponse(userData));
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<UserDataResponse> getUsers() {
        return users;
    }

    public void setUsers(List<UserDataResponse> users) {
        this.users = users;
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
