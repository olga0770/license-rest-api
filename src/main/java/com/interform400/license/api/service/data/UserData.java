package com.interform400.license.api.service.data;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.interform400.license.api.entity.Partner;
import com.interform400.license.api.entity.User;


@JsonSerialize
public class UserData {

    private final Long id;
    private final String username;
    private final String firstName;
    private final String lastName;
    private final Partner partner;

    public UserData(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.partner = user.getPartner();
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Partner getPartner() {
        return partner;
    }

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
