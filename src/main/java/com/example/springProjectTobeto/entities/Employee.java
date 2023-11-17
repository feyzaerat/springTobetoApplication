package com.example.springProjectTobeto.entities;

import jakarta.persistence.*;

@Table(name = "employees")
@Entity
public class Employee {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "full-name")
    private String fullName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "mail_address")
    private String mailAddress;

    @Column(name = "birth_date")
    private String birthDate;

    @Column(name = "created_at")
    private String createdAt;

    @Column(name = "is_active")
    private int isActive;

    @Column(name = "rank")
    private int rank;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;


}
