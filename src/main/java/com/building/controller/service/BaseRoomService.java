package com.building.controller.service;

import com.building.controller.exception.HomeNotFoundException;
import com.building.controller.model.Home;
import com.building.controller.model.Room;
import com.building.controller.repository.RoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@AllArgsConstructor
public class BaseRoomService implements RoomService {
    private final RoomRepository roomRepository;

    @Override
    public Room findRoomById(long id) {
        return roomRepository.findById(id).orElseThrow(HomeNotFoundException::new);
    }

    @Override
    public Collection<Room> findRoomByHomeId(long id) {
        Iterable<Room> all = this.roomRepository.findByHomeId(id);
        List<Room> roomList = new ArrayList<>();
        all.forEach(roomList::add);
        return roomList;
    }

    @Override
    public void saveRoom(Room room) {
        this.roomRepository.save(room);
    }

    @Override
    public void update(Room room) {
        if (room.getId() == null || !this.roomRepository.existsById(room.getId())) {
            throw new HomeNotFoundException();
        }
        this.roomRepository.save(room);
    }
}
