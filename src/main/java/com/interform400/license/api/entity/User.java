package com.interform400.license.api.entity;

import javax.persistence.*;

@Entity
public class User {


    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO) // issue with H2 - after inserts in data.sql, it does not know about the next available id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String username;

    public User() {
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
}
