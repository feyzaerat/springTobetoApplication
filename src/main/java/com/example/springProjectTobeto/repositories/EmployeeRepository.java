package com.example.springProjectTobeto.repositories;


import com.example.springProjectTobeto.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    boolean existsByMailAddress(String MailAddress);

    boolean existsByPhoneNumber(String PhoneNumber);

    List<Employee> findByFullNameLike(String fullName);
}
