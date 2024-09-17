package com.team_spak.car_rental.service.interfaces;

import com.team_spak.car_rental.model.dto.CreateCarDTO;
import com.team_spak.car_rental.model.dto.ResponseCarDto;
import com.team_spak.car_rental.model.entity.Car;

import java.util.List;

public interface CarServiceInterface {

    List<ResponseCarDto> findByCategoryId(long categoryId);


     ResponseCarDto saveNewCar(CreateCarDTO createCarDTO, long categoryId);

     ResponseCarDto findCarById (Long id);

     ResponseCarDto updateExistingCar (Long id, CreateCarDTO createCarDTO);

     String deleteCarById (Long id);

     List<ResponseCarDto> findByBrandAndModel(String brand, String model);

}
