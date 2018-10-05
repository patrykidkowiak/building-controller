package com.building.controller.controller;

import com.building.controller.model.Home;
import com.building.controller.service.AuthenticationService;
import com.building.controller.service.BaseHomeService;
import com.building.controller.service.BaseRoomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.building.controller.model.Room;
import com.building.controller.repository.RoomRepository;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class RoomController {
    private BaseRoomService baseRoomService;

    public RoomController(BaseRoomService baseRoomService) {
        this.baseRoomService = baseRoomService;
    }

    @GetMapping(path = "/room/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Room> getRoom(@PathVariable Long id) {
        Room roomById = baseRoomService.findRoomById(id);
        return ResponseEntity.ok(roomById);
    }

    @GetMapping(path = "/rooms/{homeId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Collection<Room>> getAllRooms(@PathVariable Long homeId) {
        System.out.println("rooms");
        return ResponseEntity.ok(baseRoomService.findRoomByHomeId(homeId));
    }

    @PostMapping(
            path = "/room",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Room> createRoom(@RequestBody Room room) {
        this.baseRoomService.saveRoom(room);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping(path = "/room", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Room> updateRoom(
            @RequestBody @Valid Room room, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }
        this.baseRoomService.update(room);
        return ResponseEntity.ok(room);
    }
}