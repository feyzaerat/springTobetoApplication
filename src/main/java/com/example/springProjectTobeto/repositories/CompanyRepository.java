package com.example.springProjectTobeto.repositories;

import com.example.springProjectTobeto.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company,Integer> {

    List<Company> findByNameOrIdEquals(String name, int id);

}
