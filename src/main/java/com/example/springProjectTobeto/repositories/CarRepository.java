package com.example.springProjectTobeto.repositories;

import com.example.springProjectTobeto.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car,Integer> {
    boolean existsByModelName(String modelName);
}
