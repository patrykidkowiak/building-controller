package com.building.controller.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class ElectricalSocket {
    private Long id;
    private String electricalSocketName;
    private Room room;
    private Boolean onOff;
    private SilentMode silentMode;
    private AutoMode autoMode;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getElectricalSocketName() {
        return electricalSocketName;
    }

    public void setElectricalSocketName(String electricalSocketName) {
        this.electricalSocketName = electricalSocketName;
    }

    @ManyToOne
    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Boolean getOnOff() {
        return onOff;
    }

    public void setOnOff(Boolean onOff) {
        this.onOff = onOff;
    }

    public SilentMode getSilentMode() {
        return silentMode;
    }

    public void setSilentMode(SilentMode silentMode) {
        this.silentMode = silentMode;
    }

    public AutoMode getAutoMode() {
        return autoMode;
    }

    public void setAutoMode(AutoMode autoMode) {
        this.autoMode = autoMode;
    }
}
