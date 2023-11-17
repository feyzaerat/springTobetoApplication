package com.example.springProjectTobeto.entities;

import jakarta.persistence.*;

@Table(name = "policies")
@Entity

public class Policy {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "created_at")
    private String createdAt;

    @Column(name = "end_date")
    private String endDate;

    @Column(name = "is-active")
    private int isActive;

    @Column(name = "rank")
    private int rank;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    @JoinColumn(name = "employee_id")
    private Employee employee;

    @JoinColumn(name = "company_id")
    private Company company;
}
