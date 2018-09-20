package com.building.controller.repository;

import org.springframework.data.repository.CrudRepository;
import com.building.controller.model.Room;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {
    Iterable<Room> findByHomeId(long id);
}
