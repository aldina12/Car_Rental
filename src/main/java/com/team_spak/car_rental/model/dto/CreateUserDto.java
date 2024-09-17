package com.team_spak.car_rental.model.dto;

import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserDto {

    @Email
    private String email;
    private String username;
    private String password;

}
