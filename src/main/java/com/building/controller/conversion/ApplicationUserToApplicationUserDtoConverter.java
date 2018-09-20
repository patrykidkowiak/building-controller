package com.building.controller.conversion;

import com.building.controller.dto.ApplicationUserDto;
import com.building.controller.model.ApplicationUser;
import org.springframework.core.convert.converter.Converter;

public class ApplicationUserToApplicationUserDtoConverter
        implements Converter<ApplicationUser, ApplicationUserDto> {

    @Override
    public ApplicationUserDto convert(ApplicationUser applicationUser) {
        ApplicationUserDto applicationUserDto = new ApplicationUserDto();
        applicationUserDto.setId(applicationUser.getId());
        applicationUserDto.setFirstName(applicationUser.getFirstName());
        applicationUserDto.setLastName(applicationUser.getLastName());
        applicationUserDto.setEmail(applicationUser.getEmail());

        return applicationUserDto;
    }
}
