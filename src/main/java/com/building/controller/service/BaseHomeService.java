package com.building.controller.service;

import com.building.controller.exception.HomeNotFoundException;
import com.building.controller.model.Home;
import com.building.controller.repository.HomeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@AllArgsConstructor
public class BaseHomeService implements HomeService {

    private final HomeRepository homeRepository;

    @Override
    public Home findHomeById(long id) {
        return homeRepository.findById(id).orElseThrow(HomeNotFoundException::new);
    }

    @Override
    public Collection<Home> findHomesByUserId(long id) {
        Iterable<Home> all = this.homeRepository.findByUserId(id);
        List<Home> homeList = new ArrayList<>();
        all.forEach(homeList::add);
        return homeList;
    }

    @Override
    public void saveHome(Home home) {
        this.homeRepository.save(home);
    }

    @Override
    public void update(Home home) {
        if (home.getId() == null || !this.homeRepository.existsById(home.getId())) {
            throw new HomeNotFoundException();
        }
        this.homeRepository.save(home);
    }
}
