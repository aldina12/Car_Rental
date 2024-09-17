package com.team_spak.car_rental.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "categories")
public class Category {
@Id
@GeneratedValue (strategy = GenerationType.AUTO)
private  long id ;

private  String  name  ;
private String description ;










}
