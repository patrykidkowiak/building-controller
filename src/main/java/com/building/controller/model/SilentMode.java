package com.building.controller.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
public class SilentMode {
    private Boolean silentModeActive;
    private Integer silentIntensity;
    private Integer silentTimeOnH;
    private Integer silentTimeOnM;
    private Integer silentTimeOffH;
    private Integer silentTimeOffM;
}
