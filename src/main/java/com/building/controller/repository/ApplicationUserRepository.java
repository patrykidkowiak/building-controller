package com.building.controller.repository;

import com.building.controller.model.ApplicationUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApplicationUserRepository extends CrudRepository<ApplicationUser, Long> {
    Optional<ApplicationUser> findByEmail(String email);

    boolean existsByEmail(String email);

    Optional<ApplicationUser> findByactivationHash(String token);
}
