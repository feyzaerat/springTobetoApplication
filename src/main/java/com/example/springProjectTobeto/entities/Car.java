package com.example.springProjectTobeto.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Table(name="cars")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Car {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "model_year")
    private int modelYear;
    @Column(name = "model_name")
    private String modelName;







}