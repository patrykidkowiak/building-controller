package com.building.controller.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
public class AutoMode {
    private Boolean autoModeActive;
    private Boolean offAtDay;
    private Boolean onAtNight;
    private Integer autoTimeOnH;
    private Integer autoTimeOnM;
    private Integer autoTimeOffH;
    private Integer autoTimeOffM;
}
