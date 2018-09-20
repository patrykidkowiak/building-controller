package com.building.controller.controller;

import com.building.controller.dto.ApplicationUserDto;
import com.building.controller.model.ApplicationUser;
import com.building.controller.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity registerUser(
            @RequestBody @Valid ApplicationUser applicationUser, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<String> errors =
                    bindingResult
                            .getAllErrors()
                            .stream()
                            .map(DefaultMessageSourceResolvable::getDefaultMessage)
                            .collect(Collectors.toList());
            return ResponseEntity.badRequest().body(errors);
        }

        authenticationService.saveUser(applicationUser);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @RequestMapping(value = "/account", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ApplicationUserDto> currentUserName(Authentication authentication) {
        String email = authentication.getName();
        ApplicationUserDto userDto = authenticationService.getUserData(email);
        return ResponseEntity.ok(userDto);
    }

    @RequestMapping(value = "/activate/{token}", method = RequestMethod.GET)
    public ResponseEntity confirmRegistration(@PathVariable String token) {
        authenticationService.activateUserDataByToken(token);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
