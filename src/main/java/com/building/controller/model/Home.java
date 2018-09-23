package com.building.controller.model;


import javax.persistence.*;

@Entity
public class Home {
    private Long id;
    private String homeName;
    private ApplicationUser user;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long i) {
        this.id = i;
    }

    public String getHomeName() {
        return homeName;
    }

    public void setHomeName(String homeName) {
        this.homeName = homeName;
    }

    @ManyToOne
    public ApplicationUser getUser() {
        return user;
    }

    public void setUser(ApplicationUser user) {
        this.user = user;
    }
}

