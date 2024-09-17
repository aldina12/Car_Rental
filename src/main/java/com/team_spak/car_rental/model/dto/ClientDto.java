package com.team_spak.car_rental.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientDto extends CreateUserDto {
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
}
