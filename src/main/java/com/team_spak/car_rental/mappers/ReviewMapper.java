package com.team_spak.car_rental.mappers;

import com.team_spak.car_rental.model.dto.CreateReviewDto;
import com.team_spak.car_rental.model.dto.ResponseReviewDto;
import com.team_spak.car_rental.model.entity.Review;
import org.springframework.stereotype.Component;

@Component
public class ReviewMapper {
    public Review mapToEntity(CreateReviewDto createReviewDto) {
        Review review = new Review();
        review.setUserName(createReviewDto.getUserName());
        review.setComment(createReviewDto.getComment());
        review.setRating(createReviewDto.getRating());
        return review;
    }

    public ResponseReviewDto mapToResponse(Review review) {
        ResponseReviewDto responseReviewDto = new ResponseReviewDto();
        responseReviewDto.setUserName(review.getUserName());
        responseReviewDto.setComment(review.getComment());
        responseReviewDto.setRating(review.getRating());
        responseReviewDto.setId(review.getId());
        return responseReviewDto;
    }
}
