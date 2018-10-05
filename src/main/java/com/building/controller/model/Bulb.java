package com.building.controller.model;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

@Entity
@Configuration
@EnableScheduling
public class Bulb {
    private Long id;
    private String bulbName;
    private Room room;
    private Boolean onOff;
    private AutoMode autoMode;
    private SilentMode silentMode;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBulbName() {
        return bulbName;
    }

    public void setBulbName(String bulbName) {
        this.bulbName = bulbName;
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

    public AutoMode getAutoMode() {
        return autoMode;
    }

    public void setAutoMode(AutoMode autoMode) {
        this.autoMode = autoMode;
    }

    public SilentMode getSilentMode() {
        return silentMode;
    }

    public void setSilentMode(SilentMode silentMode) {
        this.silentMode = silentMode;
    }

}