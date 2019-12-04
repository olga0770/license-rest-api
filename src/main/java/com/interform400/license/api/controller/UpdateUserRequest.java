package com.interform400.license.api.controller;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
@SuppressWarnings("unused")
public class UpdateUserRequest {

    private final String username;
    private final String password;
    private final Long partnerId;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String phone;
    private final String address;
    private final String zip;
    private final String city;
    private final String country;

    public UpdateUserRequest(String username, String password, Long partnerId, String firstName, String lastName, String email, String phone, String address, String zip, String city, String country) {
        this.username = username;
        this.password = password;
        this.partnerId = partnerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.zip = zip;
        this.city = city;
        this.country = country;
    }

    String getUsername() {
        return username;
    }

    String getPassword() { return password; }

    public Long getPartnerId() {
        return partnerId;
    }

    String getFirstName() { return firstName; }

    String getLastName() { return lastName; }

    String getEmail() { return email; }

    String getPhone() { return phone; }

    String getAddress() { return address; }

    String getZip() { return zip; }

    String getCity() { return city; }

    String getCountry() { return  country; }
}
