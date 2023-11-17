package com.example.springProjectTobeto.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "companies")
@Entity

public class Company {
    @Id
    @Column(name = "id")
    private int id;


    @Column(name = "name")
    private String name;

    @Column(name = "contact_name")
    private String contactName;

    @Column(name = "contact_phone")
    private String contactPhone;

    @Column(name = "address")
    private String address;

    @Column(name = "is_active")
    private int isActive;

    @Column(name = "rank")
    private int rank;

    @Column(name = "created_at")
    private String createdAt;

}
