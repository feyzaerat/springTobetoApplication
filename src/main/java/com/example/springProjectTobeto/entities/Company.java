package com.example.springProjectTobeto.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "companies")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Company {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name = "name")
    private String name;

    @Column(name = "contact_name")
    private String contactName;

    @Column(name = "contact_phone")
    private String contactPhone;

    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "company")
    @JsonIgnore
    private List<Policy> policies;


}
