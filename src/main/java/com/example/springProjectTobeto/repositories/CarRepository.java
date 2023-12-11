package com.example.springProjectTobeto.repositories;

import com.example.springProjectTobeto.entities.Car;
import com.example.springProjectTobeto.services.dtos.responses.car.GetCarListResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {
    boolean existsByName(String name);

    List<Car> findByNameLikeOrIdEquals(String name, int id);

    @Query("SELECT b FROM Car b Where b.name LIKE %:name%")
    List<Car> searchAsLike(String name);

    @Query(value = "Select * from cars Where name LIKE %:name%", nativeQuery = true)
    List<Car> searchAsValue(String name);

    @Query("SELECT new com.example.springProjectTobeto.services.dtos.responses.car.GetCarListResponse(b.name) " +
            "FROM Car b Where b.name LIKE %:name%")
    List<GetCarListResponse> searchAsList(String name);
}
