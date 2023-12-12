package com.example.springProjectTobeto.repositories;

import com.example.springProjectTobeto.entities.Policy;
import com.example.springProjectTobeto.services.dtos.responses.policy.GetPolicyListResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PolicyRepository extends JpaRepository<Policy, Integer> {

    boolean existsByName(String name);

    List<Policy> findByNameLike(String name);

    @Query("SELECT p FROM Policy p Where p.name LIKE %:name%")
    List<Policy> searchAsLike(String name);

    @Query(value = "Select * from policies Where name LIKE %:name%", nativeQuery = true)
    List<Policy> searchAsValue(String name);

    @Query("SELECT new com.example.springProjectTobeto.services.dtos.responses.policy.GetPolicyListResponse(p.name) " +
            "FROM Policy p Where p.name LIKE %:name%")
    List<GetPolicyListResponse> searchAsList(String name);

}
