package com.team_spak.car_rental.model.entity;

import jakarta.persistence.*;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "cars" )
public class Car {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "Brand field should not be empty")
    private String brand;
    private String model;

    @Min(value = 2005, message = "Car should not be older than 2005")
    private int year;
    private String color;
    private String engine;
    private String price;
    private boolean available;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Review> reviewSet;

}
