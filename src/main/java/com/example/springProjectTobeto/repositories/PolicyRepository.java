package com.example.springProjectTobeto.repositories;

import com.example.springProjectTobeto.entities.Policy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PolicyRepository extends JpaRepository<Policy, Integer> {

    boolean existsByName(String name);

    List<Policy> findByNameLike(String name);

}
