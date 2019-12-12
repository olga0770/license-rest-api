package com.interform400.license.api.controller.request;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class CreateUserRequest {

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
    private final String role;


    @SuppressWarnings("squid:S00107")
    public CreateUserRequest(String username, String password, Long partnerId, String firstName, String lastName,
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

}
