package com.example.springProjectTobeto.repositories;

import com.example.springProjectTobeto.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    List<Department> findByNameLike(String name);

    boolean existsByName(String name);

}
