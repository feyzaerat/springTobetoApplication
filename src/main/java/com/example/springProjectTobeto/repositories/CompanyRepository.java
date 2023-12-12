package com.example.springProjectTobeto.repositories;

import com.example.springProjectTobeto.entities.Company;
import com.example.springProjectTobeto.services.dtos.responses.company.GetCompanyListResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

    List<Company> findByNameLikeOrIdEquals(String name, int id);

    boolean existsByName(String name);

    boolean existsByContactPhone(String contactPhone);

    @Query("SELECT c FROM Company c Where c.name LIKE %:name%")
    List<Company> searchAsLike(String name);

    @Query(value = "Select * from companies Where name LIKE %:name%", nativeQuery = true)
    List<Company> searchAsValue(String name);


    @Query("SELECT new com.example.springProjectTobeto.services.dtos.responses.company.GetCompanyListResponse(c.name) " +
            "FROM Company c Where c.name LIKE %:name%")
    List<GetCompanyListResponse> searchAsList(String name);

}
