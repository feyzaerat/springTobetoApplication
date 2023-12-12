package com.example.springProjectTobeto.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "departments")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

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


   /* @OneToMany(mappedBy = "employee")
    private List<Employee> employees;*/


}
