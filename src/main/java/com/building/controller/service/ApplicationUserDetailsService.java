package com.building.controller.service;

import com.building.controller.exception.ApplicationUserNotFoundException;
import com.building.controller.model.ApplicationUser;
import com.building.controller.repository.ApplicationUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class ApplicationUserDetailsService implements UserDetailsService {

  private final ApplicationUserRepository applicationUserRepository;


  @Override
  public UserDetails loadUserByUsername(String email) {
    ApplicationUser applicationUser =
        applicationUserRepository
            .findByEmail(email)
            .orElseThrow(ApplicationUserNotFoundException::new);
    GrantedAuthority ga = new SimpleGrantedAuthority("USER");
    return new User(
        applicationUser.getEmail(),
        applicationUser.getPassword(),
        applicationUser.isActivated(),
        true,
        true,
        true,
        Arrays.asList(ga));
  }
}
