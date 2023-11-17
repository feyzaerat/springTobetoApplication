package com.example.springProjectTobeto.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Table(name = "customers")
@Entity

public class Customer {

    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phone;

    @Column(name = "mail_address")
    private String mailAddress;

    @Column(name = "is_active")
    private int isActive;

    @Column(name = "rank")
    private int rank;

    @Column(name = "created_at")
    private Date createdAt;


}
