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
    private final List<UserData> users;

    public PartnerData(Partner partner) {
        this.id = partner.getId();
        this.companyName = partner.getCompanyName();
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
}
