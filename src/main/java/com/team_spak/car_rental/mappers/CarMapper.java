package com.team_spak.car_rental.mappers;

import com.team_spak.car_rental.model.dto.CreateCarDTO;
import com.team_spak.car_rental.model.dto.ResponseCarDto;
import com.team_spak.car_rental.model.dto.ResponseReviewDto;
import com.team_spak.car_rental.model.entity.Car;
import com.team_spak.car_rental.model.entity.Review;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class CarMapper {

    private final ReviewMapper reviewMapper;

    public Car mapToEntity(CreateCarDTO createCarDTO) {
        Car car = new Car();
        car.setBrand(createCarDTO.getBrand());
        car.setModel(createCarDTO.getModel());
        car.setPrice(createCarDTO.getPrice());
        car.setYear(createCarDTO.getYear());
        car.setColor(createCarDTO.getColor());
        car.setEngine(createCarDTO.getEngine());
        car.setAvailable(createCarDTO.isAvailable());

        return car;
    }
    public ResponseCarDto mapToResponse(Car car) {
        ResponseCarDto responseCarDTO = new ResponseCarDto();
        responseCarDTO.setBrand(car.getBrand());
        responseCarDTO.setModel(car.getModel());
        responseCarDTO.setPrice(car.getPrice());
        responseCarDTO.setYear(car.getYear());
        responseCarDTO.setColor(car.getColor());
        responseCarDTO.setEngine(car.getEngine());
        responseCarDTO.setAvailable(car.isAvailable());
        responseCarDTO.setId(car.getId());


        Set<Review> reviewSetEntity = car.getReviewSet();
        Set<ResponseReviewDto> setOfResponseReviewDto = new HashSet<>();
        if (reviewSetEntity != null) {
            for (Review review: reviewSetEntity) {
                setOfResponseReviewDto.add(reviewMapper.mapToResponse(review));
            }
            responseCarDTO.setReviews(setOfResponseReviewDto);
            responseCarDTO.setReviews(car.getReviewSet().stream().map(reviewMapper::mapToResponse).collect(Collectors.toSet()));
        }else{
            responseCarDTO.setReviews(new HashSet<>());
        }

        return responseCarDTO;
    }
}
