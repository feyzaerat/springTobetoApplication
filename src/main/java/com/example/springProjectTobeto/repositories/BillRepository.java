package com.example.springProjectTobeto.repositories;

import com.example.springProjectTobeto.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill,Integer> {
}
