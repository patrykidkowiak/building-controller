package com.building.controller.service;

import com.building.controller.model.Bulb;
import com.building.controller.model.Room;

import java.util.Collection;

public interface BulbService {
    Bulb findBulbById(long id);

    Collection<Bulb> findBulbsByRoomId(long id);

    void saveBulb(Bulb bulb);

    void update(Bulb bulb);
}
