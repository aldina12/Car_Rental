package com.team_spak.car_rental.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCarDTO {


    private String brand;
    private String model;
    private String price;
    private int year;
    private String color;
    private String engine;
    private boolean available;


}
