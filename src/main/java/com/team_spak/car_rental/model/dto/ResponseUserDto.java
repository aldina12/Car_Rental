package com.team_spak.car_rental.model.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ResponseUserDto {

    private Long id;

    private String email;
    private String username;
    private String password;
}
