package com.building.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApplicationUserDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
