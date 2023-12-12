package com.example.springProjectTobeto.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "orders")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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


    @ManyToOne

    @JoinColumn(name = "employee_id")
    private Employee employee;


    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;


    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;


}

