package com.example.springProjectTobeto.repositories;

import com.example.springProjectTobeto.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface BillRepository extends JpaRepository<Bill,Integer> {


    boolean existsByName(String name);



    List<Bill> findByNameLike(String name);
}
