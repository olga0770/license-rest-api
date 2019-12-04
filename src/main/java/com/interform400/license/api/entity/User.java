package com.interform400.license.api.entity;

import javax.persistence.*;

@Entity
@SuppressWarnings("unused")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable=false, updatable = false)
    private Long id;

    @Column(nullable=false, unique = true, length=255)
    private String username;

    @Column
    private String password;

    @Column(name = "firstname", nullable = false, length=255)
    private String firstName;

    @Column(name = "lastname", nullable = false, length=255)
    private String lastName;


    @Column(nullable = false, length=255)
    private String email;

    @Column(nullable = false, length=255)
    private String phone;

    @Column(nullable = false, length=255)
    private String address;

    @Column(nullable = false, length=255)
    private String zip;

    @Column(nullable = false, length=255)
    private String city;

    @Column(nullable = false, length=255)
    private String country;


    public User() {
        // no-op
    }

    @ManyToOne
    @JoinColumn(name = "partnerid")
    private Partner partner;


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

    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner partner) {
        this.partner = partner;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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




}
