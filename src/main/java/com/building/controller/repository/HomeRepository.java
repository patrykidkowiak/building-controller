package com.building.controller.repository;

import org.springframework.data.repository.CrudRepository;
import com.building.controller.model.Home;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeRepository extends CrudRepository<Home, Long> {
        Iterable<Home> findByUserId(Long userId);
}
