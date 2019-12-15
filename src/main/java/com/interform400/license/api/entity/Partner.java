package com.interform400.license.api.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The partner entity
 */
@Entity
@SuppressWarnings("unused")
public class Partner {

    public Partner() {
        users = new ArrayList<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "companyname")
    private String companyName;

    @OneToMany(mappedBy = "partner")
    private List<User> users;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
