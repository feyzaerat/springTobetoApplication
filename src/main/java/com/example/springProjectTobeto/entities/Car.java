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

    @Column(name = "is_active")
    private int isActive;

    @Column(name = "rank")
    private int rank;

    @Column(name = "created_at")
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;


}