package com.example.springProjectTobeto.repositories;

import com.example.springProjectTobeto.entities.Bill;
import com.example.springProjectTobeto.services.dtos.responses.bill.GetBillListResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BillRepository extends JpaRepository<Bill, Integer> {
    boolean existsByName(String name);
    List<Bill> findByNameLike(String name);

    @Query("SELECT b FROM Bill b Where b.name LIKE %:name%")
    List<Bill> searchAsLike(String name);

    @Query(value = "SELECT * FROM bills WHERE name LIKE %:name%", nativeQuery = true)
    List<Bill> searchAsValue(String name);

    @Query("SELECT new com.example.springProjectTobeto.services.dtos.responses.bill.GetBillListResponse(b.name) " +
    "FROM Bill b WHERE b.name LIKE %:name%")
    List<GetBillListResponse> searchAsList(String name);
}
