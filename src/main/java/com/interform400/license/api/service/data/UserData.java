package com.interform400.license.api.service.data;

import com.interform400.license.api.entity.User;

/**
 * Generic information for a user, POJO class.
 */
public class UserData {

    private final Long id;
    private final String username;
    private final String password;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String phone;
    private final String address;
    private final String zip;
    private final String city;
    private final String country;

    private final Long partnerId;
    private final String companyName;


    public UserData(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.phone = user.getPhone();
        this.address = user.getAddress();
        this.zip = user.getZip();
        this.city = user.getCity();
        this.country = user.getCountry();
        this.partnerId = user.getPartner().getId();
        this.companyName = user.getPartner().getCompanyName();
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
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getAddress() { return address; }
    public String getZip() { return zip; }
    public String getCity() { return city; }
    public String getCountry() { return country; }

    public Long getPartnerId() {
        return partnerId;
    }

    public String getCompanyName() {
        return companyName;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", zip='" + zip + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", partnerId=" + partnerId +
                ", companyName='" + companyName + '\'' +
                '}';
    }
}
