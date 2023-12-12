package com.example.springProjectTobeto.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "customers")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Customer {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phone;

    @Column(name = "mail_address")
    private String mailAddress;

    @Column(name = "address")
    private String address;


}
