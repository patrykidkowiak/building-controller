package com.building.controller.controller;

import com.building.controller.model.Bulb;
import com.building.controller.model.Room;
import com.building.controller.service.AuthenticationService;
import com.building.controller.service.BaseBulbService;
import com.building.controller.service.BaseHomeService;
import com.building.controller.service.BaseRoomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping("/api/v1")
public class BulbController {
    private BaseBulbService baseBulbService;

    public BulbController(BaseBulbService baseBulbService) {
        this.baseBulbService = baseBulbService;
    }

    @GetMapping(path = "/bulb/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Bulb> getBulb(@PathVariable Long id) {
        Bulb bulbById = baseBulbService.findBulbById(id);
        return ResponseEntity.ok(bulbById);
    }

    @GetMapping(path = "/bulbs/{roomId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Collection<Bulb>> getAllBulbs(@PathVariable Long roomId) {
        return ResponseEntity.ok(baseBulbService.findBulbsByRoomId(roomId));
    }

    @PostMapping(
            path = "/bulb",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Room> createBulb(@RequestBody Bulb bulb) {
        this.baseBulbService.saveBulb(bulb);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping(path = "/bulb", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Bulb> updatebulb(
            @RequestBody @Valid Bulb bulb, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }
        this.baseBulbService.update(bulb);
        return ResponseEntity.ok(bulb);
    }


}