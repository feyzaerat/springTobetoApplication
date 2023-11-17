package com.example.springProjectTobeto.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Table(name = "departments")
@Entity

public class Department {

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

    @Column(name = "created_at")
    private Date createdAt;


}
