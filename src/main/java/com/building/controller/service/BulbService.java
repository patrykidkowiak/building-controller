package com.building.controller.service;

import com.building.controller.model.Room;

import java.util.Collection;

public interface RoomService {
    Room findRoomById(long id);

    Collection<Room> findRoomByHomeId(long id);

    void saveRoom(Room room);

    void update(Room room);
}
