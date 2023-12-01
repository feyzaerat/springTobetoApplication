package com.example.springProjectTobeto.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Table(name = "brands")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Brand {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name = "name")
    private String name;
    private int isActive;
    private int rank;


}
