package com.building.controller.service;

import com.building.controller.exception.BulbNotFoundException;
import com.building.controller.exception.HomeNotFoundException;
import com.building.controller.model.Bulb;
import com.building.controller.model.Room;
import com.building.controller.repository.BulbRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@AllArgsConstructor
public class BaseBulbService implements BulbService {
    private final BulbRepository bulbRepository;

    @Override
    public Bulb findBulbById(long id) {
        return bulbRepository.findById(id).orElseThrow(BulbNotFoundException::new);
    }

    @Override
    public Collection<Bulb> findBulbsByRoomId(long id) {
        Iterable<Bulb> all = this.bulbRepository.findByRoomId(id);
        List<Bulb> bulbList = new ArrayList<>();
        all.forEach(bulbList::add);
        return bulbList;
    }

    @Override
    public void saveBulb(Bulb bulb) {
        this.bulbRepository.save(bulb);
    }

    @Override
    public void update(Bulb bulb) {
        System.out.println(bulb.getId());
        if (bulb.getId() == null || !this.bulbRepository.existsById(bulb.getId())) {
            throw new BulbNotFoundException();
        }
        this.bulbRepository.save(bulb);
    }
}
