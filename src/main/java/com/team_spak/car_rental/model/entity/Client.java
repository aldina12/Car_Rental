package com.team_spak.car_rental.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "clients")
public class Client {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;
    private String phone;
    private String address;

}
