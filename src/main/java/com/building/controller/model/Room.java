package com.building.controller.model;

import javax.persistence.*;

@Entity
public class Room {
    private String roomName;
    private Long id;
    private Home home;

    public String getName() {
        return roomName;
    }

    public void setName(String name) {
        this.roomName = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    @ManyToOne
    public Home getHome() {
        return home;
    }

    public void setHome(Home home) {
        this.home = home;
    }
}
