package com.example.springProjectTobeto.repositories;

import com.example.springProjectTobeto.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car,Integer> {
    boolean existsByName(String name);
    List<Car> findByNameLikeOrIdEquals(String name, int id);
}
