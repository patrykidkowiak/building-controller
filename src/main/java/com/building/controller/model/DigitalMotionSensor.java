package com.building.controller.model;

import javax.persistence.*;

@Entity
public class DigitalMotionSensor {
    private Long id;
    private String name;
    private Boolean motionDetected;
    private Room room;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Boolean getMotionDetected() {
        return motionDetected;
    }

    public void setMotionDetected(Boolean motionDetected) {
        this.motionDetected = motionDetected;
    }

    @ManyToOne
    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
