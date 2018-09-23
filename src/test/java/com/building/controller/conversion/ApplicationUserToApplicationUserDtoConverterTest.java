package com.building.controller.conversion;

import com.building.controller.conversion.ApplicationUserToApplicationUserDtoConverter;
import com.building.controller.dto.ApplicationUserDto;
import com.building.controller.model.ApplicationUser;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ApplicationUserToApplicationUserDtoConverterTest {

  ApplicationUser applicationUser;

  @Before
  public void init() {
    this.applicationUser = new ApplicationUser();
    applicationUser.setId(5L);
    applicationUser.setEmail("email@email.com");
    applicationUser.setFirstName("testfirstname");
    applicationUser.setLastName("testlastname");
  }

  @Test
  public void shouldHaveSameParametersAfterConversion() {
    // When
    ApplicationUserDto applicationUserDto =
        new ApplicationUserToApplicationUserDtoConverter().convert(applicationUser);

    // Then
    assertEquals(
        "Converted user has invalid id", applicationUser.getId(), applicationUserDto.getId());
    assertEquals(
        "Converted user has invalid email",
        applicationUser.getEmail(),
        applicationUserDto.getEmail());
    assertEquals(
        "Converted user has invalid firstname",
        applicationUser.getFirstName(),
        applicationUserDto.getFirstName());
    assertEquals(
        "Converted user has invalid lastname",
        applicationUser.getLastName(),
        applicationUserDto.getLastName());
  }
}
