package com.example.springProjectTobeto.entities;

import jakarta.persistence.*;

@Table(name = "orders")
@Entity
public class Order {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "unit_price")
    private double unitPrice;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "is_active")
    private int isActive;

    @Column(name = "rank")
    private int rank;

    @Column(name = "created_at")
    private String createdAt;

    @ManyToOne

    @JoinColumn(name = "employee_id")
    private Employee employee;
    @JoinColumn(name = "car_id")
    private Car car;

    @JoinColumn(name="customer_id")
    private Customer customer;

    @JoinColumn(name="bill_id")
    private Bill bill;





}

