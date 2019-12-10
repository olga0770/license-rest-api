package com.interform400.license.api.controller.response;

import com.interform400.license.api.entity.Partner;
import com.interform400.license.api.service.data.UserData;

public class UserDataResponse {

    private Long id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private Partner partner;
    private String email;
    private String phone;
    private String address;
    private String zip;
    private String city;
    private String country;

    public UserDataResponse(UserData userData) {
        this.id = userData.getId();
        this.username = userData.getUsername();
        this.password = userData.getPassword();
        this.firstName = userData.getFirstName();
        this.lastName = userData.getLastName();
        this.partner = userData.getPartner();
        this.email = userData.getEmail();
        this.phone = userData.getPhone();
        this.address = userData.getAddress();
        this.zip = userData.getZip();
        this.city = userData.getCity();
        this.country = userData.getCountry();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner partner) {
        this.partner = partner;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
