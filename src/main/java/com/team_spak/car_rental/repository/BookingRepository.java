package com.team_spak.car_rental.repository;

import com.team_spak.car_rental.model.entity.Booking;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {

}
