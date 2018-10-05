package com.building.controller.controller;

import com.building.controller.service.AuthenticationService;
import com.building.controller.service.HomeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.building.controller.model.Home;
import com.building.controller.repository.HomeRepository;

import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(exposedHeaders = "errors, content-type")
public class HomeController {
    public HomeService homeService;
    private final AuthenticationService authenticationService;

    public HomeController(HomeService homeService, AuthenticationService authenticationService) {
        this.homeService = homeService;
        this.authenticationService = authenticationService;
    }

    @GetMapping(path = "/home/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Home> getHomeById(@PathVariable Long id) {
        Home homeById = homeService.findHomeById(id);
        return ResponseEntity.ok(homeById);
    }

    @GetMapping(path = "/homes", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Collection<Home>> getAllHomes(Authentication authentication) {
        Long userId = authenticationService.getUserData(authentication.getName()).getId();
        System.out.println(authentication.getName());
        return ResponseEntity.ok(homeService.findHomesByUserId(userId));
    }

    @PostMapping(
            path = "/home",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Home> createHome(@RequestBody Home home) {
        this.homeService.saveHome(home);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping(path = "/home", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Home> updateHome(
            @RequestBody @Valid Home home, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }
        homeService.update(home);
        return ResponseEntity.ok(home);
    }
}
