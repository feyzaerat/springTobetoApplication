package com.example.springProjectTobeto.repositories;

import com.example.springProjectTobeto.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository <Order, Integer> {
    boolean existsByName(String name);
}
