package com.interform400.license.api.service.data;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.interform400.license.api.entity.Partner;
import com.interform400.license.api.entity.User;


@JsonSerialize
public class UserData {

    private final Long id;
    private final String username;
    private final String password;
    private final String firstName;
    private final String lastName;
    private final Partner partner;
    private final String email;
    private final  String phone;
    private final String address;
    private final String zip;
    private final String city;
    private final String country;


    public UserData(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.partner = user.getPartner();
        this.email = user.getEmail();
        this.phone = user.getPhone();
        this.address = user.getAddress();
        this.zip = user.getZip();
        this.city = user.getCity();
        this.country = user.getCountry();
    }

    public Long getId() {
        return id;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() { return password; }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public Partner getPartner() { return partner; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getAddress() { return address; }
    public String getZip() { return zip; }
    public String getCity() { return city; }
    public String getCountry() { return country; }

    @Override
    public String toString() {
        return "UserData{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
