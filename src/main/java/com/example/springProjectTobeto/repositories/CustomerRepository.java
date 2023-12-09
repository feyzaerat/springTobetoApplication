package com.example.springProjectTobeto.repositories;

import com.example.springProjectTobeto.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    boolean existsByMailAddress(String MailAddress);

    boolean existsByPhone(String Phone);
}
