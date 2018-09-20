package com.building.controller.service;

import com.building.controller.model.Home;

import java.util.Collection;

public interface HomeService {

    Home findHomeById(long id);

    Collection<Home> findHomesByUserId(long id);

    void saveHome(Home home);

    void update(Home home);
}
