package com.team_spak.car_rental.model.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateStaffDTO extends CreateUserDto{
    private String name;
    private String lastname;
    private int age;
    private int experience;
}
