package com.team_spak.car_rental.service;

import com.team_spak.car_rental.model.dto.CreateReviewDto;
import com.team_spak.car_rental.model.dto.ResponseReviewDto;
import com.team_spak.car_rental.mappers.ReviewMapper;
import com.team_spak.car_rental.model.entity.Car;
import com.team_spak.car_rental.model.entity.Review;
import com.team_spak.car_rental.repository.CarRepository;
import com.team_spak.car_rental.repository.ReviewRepository;
import com.team_spak.car_rental.service.interfaces.ReviewServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class ReviewService implements ReviewServiceInterface {

    private ReviewRepository reviewRepository;
    private ReviewMapper reviewMapper;
    private CarRepository carRepository;

    @Override
    public List<ResponseReviewDto> findAllByReviewIdAndCarId(long carId){
        Car existingCar = carRepository.findById(carId).orElseThrow(()->new RuntimeException("Car not found"));
       // List<Review> reviewList = reviewRepository.findAll();

        List<Review> reviewList = reviewRepository.findByCarId(carId);
        List<ResponseReviewDto> responseReviewDtoList = new ArrayList<>();
        for (Review review : reviewList) {
            responseReviewDtoList.add(reviewMapper.mapToResponse(review));
        }
        return responseReviewDtoList;
    }

    @Override
    public ResponseReviewDto saveByReviewIdAndCarId(CreateReviewDto createReviewDto,long carId){
        Car existingCar = carRepository.findById(carId).orElseThrow(()->new RuntimeException("Car not found"));
        Review newReview = reviewMapper.mapToEntity(createReviewDto);

        newReview.setCar(existingCar);
        Review savedReview = reviewRepository.save(newReview);
        return reviewMapper.mapToResponse(savedReview);
    }

    @Override
    public ResponseReviewDto findByReviewIdAndCarId(long id, long carId){
        Car existingCar = carRepository.findById(carId).orElseThrow(()->new RuntimeException("Car not found"));
        Review existingReview = reviewRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Review not found"));
        if (existingReview.getCar().getId() != carId){
            throw new RuntimeException("Car doesn't belong to this review");
        }
        return reviewMapper.mapToResponse(existingReview);
    }

    @Override
    public ResponseReviewDto updateByReviewIdAndCarId(long id, CreateReviewDto createReviewDto, long carId){
        Car existingCar = carRepository.findById(carId).orElseThrow(()->new RuntimeException("Car not found"));
        Review existingReview = reviewRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Review not found"));
        if (existingReview.getCar().getId() != carId){
            throw new RuntimeException("Car doesn't belong to this review");
        }

        existingReview.setUserName(createReviewDto.getUserName());
        existingReview.setComment(createReviewDto.getComment());
        existingReview.setRating(createReviewDto.getRating());
        Review savedReview = reviewRepository.save(existingReview);
        return reviewMapper.mapToResponse(savedReview);
    }

    @Override
    public String deleteByReviewIdAndCarId(long id, Long carId){
        Car existingCar = carRepository.findById(carId).orElseThrow(()->new RuntimeException("Car not found"));
        Review existingReview = reviewRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Review not found"));
        if (existingReview.getCar().getId() != carId){
            throw new RuntimeException("Car doesn't belong to this review");
        }
        reviewRepository.delete(existingReview);

        return "Review with id" + id + "was succefully deleted";
    }

}
