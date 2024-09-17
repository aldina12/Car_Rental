package com.team_spak.car_rental.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;

    private LocalDate startDate;
    private LocalDate endDate;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "car_id")

    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private Car car;



}
