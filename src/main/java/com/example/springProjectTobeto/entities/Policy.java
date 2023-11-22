package com.example.springProjectTobeto.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Table(name = "policies")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Policy {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;


    @Column(name = "is_active")
    private int isActive;

    @Column(name = "rank")
    private int rank;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;


    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;


    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
}
