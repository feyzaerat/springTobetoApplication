package com.example.springProjectTobeto.repositories;

import com.example.springProjectTobeto.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company,Integer> {
}
