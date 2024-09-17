package com.team_spak.car_rental.repository;

import com.team_spak.car_rental.model.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CarRepository  extends JpaRepository<Car, Long> {
    List<Car> findByCategoryId(long id);

    List <Car> findByBrandAndModel(String brand, String model);


}
