package com.building.controller.repository;

import org.springframework.data.repository.CrudRepository;
import com.building.controller.model.Bulb;
import org.springframework.stereotype.Repository;

@Repository
public interface BulbRepository extends CrudRepository<Bulb, Long> {

}
