package com.team_spak.car_rental.repository;

import com.team_spak.car_rental.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<Category, Long> {

}
