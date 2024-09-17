package com.team_spak.car_rental.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class ResponseCarDto {

    private long id;
    private String brand;
    private String model;
    private String price;
    private int year;
    private String color;
    private String engine;
    private boolean available;
    private Set<ResponseReviewDto> reviews;


}
