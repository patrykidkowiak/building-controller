package com.building.controller.model;


import javax.persistence.*;

@Entity
public class Home {
    private Long id;
    private String houseName;
    private ApplicationUser user;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long i) {
        this.id = i;
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    @ManyToOne
    public ApplicationUser getUser() {
        return user;
    }

    public void setUser(ApplicationUser user) {
        this.user = user;
    }
}

