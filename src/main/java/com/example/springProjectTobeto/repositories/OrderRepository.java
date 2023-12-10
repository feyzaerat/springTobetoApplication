package com.example.springProjectTobeto.repositories;

import com.example.springProjectTobeto.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository <Order, Integer> {
    List<Order>findByQuantityEquals(int quantity);
    boolean existsByName(String name);

}
