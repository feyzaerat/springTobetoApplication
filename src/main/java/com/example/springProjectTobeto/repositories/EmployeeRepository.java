package com.example.springProjectTobeto.repositories;


import com.example.springProjectTobeto.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    boolean existsByMailAddress(String MailAddress);
    boolean existsByPhoneNumber(String PhoneNumber);
}
