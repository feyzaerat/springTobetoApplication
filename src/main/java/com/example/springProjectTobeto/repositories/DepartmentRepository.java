package com.example.springProjectTobeto.repositories;

import com.example.springProjectTobeto.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository <Department, Integer> {

    boolean existsByName(String name);

}
