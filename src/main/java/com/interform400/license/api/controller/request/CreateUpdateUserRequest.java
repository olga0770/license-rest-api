package com.interform400.license.api.controller.request;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
@SuppressWarnings("unused")
public class CreateUpdateUserRequest {

    private String username;
    private String password;
    private Long partnerId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private String zip;
    private String city;
    private String country;
    private String role;

    public CreateUpdateUserRequest() {
    }

    @SuppressWarnings("squid:S00107")
    public CreateUpdateUserRequest(String username, String password, Long partnerId, String firstName, String lastName,
                                   String email, String phone, String address, String zip, String city, String country, String role) {
        this.username = username;
        this.partnerId = partnerId;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.zip = zip;
        this.city = city;
        this.country = country;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {return password; }

    public Long getPartnerId() {
        return partnerId;
    }

    public String getFirstName() { return firstName; }

    public String getLastName() { return lastName; }


    public String getEmail() { return email; }

    public String getPhone() { return phone; }

    public String getAddress() { return address; }

    public String getZip() { return zip; }

    public String getCity() { return city; }

    public String getCountry() { return  country; }

    public String getRole() { return role; }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPartnerId(Long partnerId) {
        this.partnerId = partnerId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
