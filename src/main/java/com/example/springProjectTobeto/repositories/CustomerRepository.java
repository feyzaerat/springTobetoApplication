package com.example.springProjectTobeto.repositories;

import com.example.springProjectTobeto.entities.Brand;
import com.example.springProjectTobeto.entities.Customer;
import com.example.springProjectTobeto.services.dtos.responses.brand.GetBrandListResponse;
import com.example.springProjectTobeto.services.dtos.responses.customer.GetCustomerListResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    List<Customer> findByAddressLike(String address);

    boolean existsByMailAddress(String MailAddress);

    boolean existsByPhone(String Phone);

    @Query("SELECT c FROM Customer c Where c.address LIKE %:address%")
    List<Customer> searchAsLike(String address);

    @Query(value = "Select * from customers Where address LIKE %:address%", nativeQuery = true)
    List<Customer> searchAsValue(String address);

    @Query("SELECT new com.example.springProjectTobeto.services.dtos.responses.customer.GetCustomerListResponse(c.address) " +
            "FROM Customer c Where c.address LIKE %:address%")
    List<GetCustomerListResponse> searchAsList(String address);
}
