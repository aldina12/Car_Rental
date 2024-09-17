package com.team_spak.car_rental.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class BookingDto extends CreateCarDTO {

    private LocalDate startDate;
    private LocalDate endDate;


}
