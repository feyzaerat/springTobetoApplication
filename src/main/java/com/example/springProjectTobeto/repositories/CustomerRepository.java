package com.example.springProjectTobeto.repositories;

import com.example.springProjectTobeto.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    List<Customer> findByAddressLike(String address);

    boolean existsByMailAddress(String MailAddress);

    boolean existsByPhone(String Phone);
}
