package com.team_spak.car_rental.repository;

import com.team_spak.car_rental.model.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<Staff, Integer> {
}
