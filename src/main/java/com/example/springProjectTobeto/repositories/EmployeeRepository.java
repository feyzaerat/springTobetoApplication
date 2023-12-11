package com.example.springProjectTobeto.repositories;


import com.example.springProjectTobeto.entities.Brand;
import com.example.springProjectTobeto.entities.Employee;
import com.example.springProjectTobeto.services.dtos.responses.brand.GetBrandListResponse;
import com.example.springProjectTobeto.services.dtos.responses.employee.GetEmployeeListResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    boolean existsByMailAddress(String MailAddress);

    boolean existsByPhoneNumber(String PhoneNumber);

    List<Employee> findByFullNameLike(String fullName);

    @Query("SELECT e FROM Employee e Where e.fullName LIKE %:fullName%")
    List<Employee> searchAsLike(String fullName);

    @Query(value = "Select * from employees Where full_name LIKE %:fullName%", nativeQuery = true)
    List<Employee> searchAsValue(String fullName);

    @Query("SELECT new com.example.springProjectTobeto.services.dtos.responses.employee.GetEmployeeListResponse(e.fullName) " +
            "FROM Employee e Where e.fullName LIKE %:fullName%")
    List<GetEmployeeListResponse> searchAsList(String fullName);
}
