package com.example.springProjectTobeto.entities;

import jakarta.persistence.*;

@Table(name = "bills")
@Entity

public class Bill {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "amount")
    private double amount;

    @Column(name = "type")
    private int type;

    @Column(name = "rank")
    private int rank;

    @Column(name = "created_at")
    private String createdAt;

    @ManyToOne

    @JoinColumn(name = "order_id")
    private Order order;


}
