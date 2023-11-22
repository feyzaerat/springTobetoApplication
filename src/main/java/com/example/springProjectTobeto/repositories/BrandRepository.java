package com.example.springProjectTobeto.repositories;


import com.example.springProjectTobeto.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

//DATA jpa
//Generic
public interface BrandRepository extends JpaRepository<Brand,Integer> {

}
