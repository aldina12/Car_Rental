package com.team_spak.car_rental.service.interfaces;

import com.team_spak.car_rental.model.dto.CreateReviewDto;
import com.team_spak.car_rental.model.dto.ResponseReviewDto;

import java.util.List;

public interface ReviewServiceInterface {

    public List<ResponseReviewDto> findAllByReviewIdAndCarId(long carId);

    public ResponseReviewDto saveByReviewIdAndCarId(CreateReviewDto createReviewDto,long carId);

    public ResponseReviewDto findByReviewIdAndCarId(long id, long carId);

    public ResponseReviewDto updateByReviewIdAndCarId(long id, CreateReviewDto createReviewDto, long carId);

    public String deleteByReviewIdAndCarId(long id, Long carId);

}
