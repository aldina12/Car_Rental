package com.team_spak.car_rental.repository;

import com.team_spak.car_rental.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository  extends JpaRepository<Role, Integer> {

    Optional<Role> findByRoleName(String name);
}
