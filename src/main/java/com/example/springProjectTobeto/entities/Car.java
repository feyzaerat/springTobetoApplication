package com.example.springProjectTobeto.entities;

import jakarta.persistence.*;

@Table(name="cars")
@Entity

public class Car {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="model_year")
    private int modelYear;
    @Column(name="model_name")
    private String modelName;

    @Column(name = "is_active")
    private int isActive;

    @Column(name = "rank")
    private int rank;

    @Column(name = "created_at")
    private String createdAt;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;
}
