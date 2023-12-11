package com.example.springProjectTobeto.repositories;

import com.example.springProjectTobeto.entities.Brand;
import com.example.springProjectTobeto.entities.Department;
import com.example.springProjectTobeto.services.dtos.responses.brand.GetBrandListResponse;
import com.example.springProjectTobeto.services.dtos.responses.department.GetDepartmentListResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    List<Department> findByNameLike(String name);

    boolean existsByName(String name);

    @Query("SELECT d FROM Department d Where d.name LIKE %:name%")
    List<Department> searchAsLike(String name);

    @Query(value = "Select * from departments Where name LIKE %:name%", nativeQuery = true)
    List<Department> searchAsValue(String name);

    @Query("SELECT new com.example.springProjectTobeto.services.dtos.responses.department.GetDepartmentListResponse(d.name) " +
            "FROM Department d Where d.name LIKE %:name%")
    List<GetDepartmentListResponse> searchAsList(String name);

}
