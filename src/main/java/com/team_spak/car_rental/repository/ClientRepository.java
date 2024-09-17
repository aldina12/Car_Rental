package com.team_spak.car_rental.repository;

import com.team_spak.car_rental.model.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
