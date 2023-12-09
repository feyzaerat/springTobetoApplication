package com.example.springProjectTobeto.repositories;

import com.example.springProjectTobeto.entities.Policy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PolicyRepository extends JpaRepository<Policy, Integer> {

    boolean existsByName(String name);

}
