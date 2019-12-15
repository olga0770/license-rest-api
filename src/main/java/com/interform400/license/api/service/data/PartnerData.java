package com.interform400.license.api.service.data;

import com.interform400.license.api.entity.Partner;
import com.interform400.license.api.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Generic information for a partner, POJO class.
 */
public class PartnerData {

    private final Long id;
    private final String companyName;
    private final String address;
    private final String zip;
    private final String city;
    private final String country;
    private final List<UserData> users;

    public PartnerData(Partner partner) {
        this.id = partner.getId();
        this.companyName = partner.getCompanyName();
        this.address = partner.getAddress();
        this.zip = partner.getZip();
        this.city = partner.getCity();
        this.country = partner.getCountry();

        this.users = new ArrayList<>();
        for (User userEntity: partner.getUsers()) {
            users.add(new UserData(userEntity));
        }
    }

    public Long getId() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public List<UserData> getUsers() {
        return users;
    }

    public String getAddress() {
        return address;
    }

    public String getZip() {
        return zip;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }
}
