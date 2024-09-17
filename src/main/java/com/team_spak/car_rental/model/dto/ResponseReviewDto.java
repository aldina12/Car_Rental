package com.team_spak.car_rental.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseReviewDto {

    private Long id;
    private String userName;
    private String comment;
    private int rating;
}
