package com.example.springProjectTobeto.repositories;

import com.example.springProjectTobeto.entities.Brand;
import com.example.springProjectTobeto.services.dtos.responses.brand.GetBrandListResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand, Integer> {

    // Derived Query Methods
    List<Brand> findByNameLikeOrIdEquals(String name, int id);

    List<Brand> findByName(String name);

    boolean existsByName(String name);

    // Select * from brands
    // JPQL => SQL'dekinin tersine tablo ismi değil entity ismi kullanılır.
    @Query("SELECT b FROM Brand b Where b.name LIKE %:name%")
    List<Brand> search(String name);

    @Query(value = "Select * from brands Where name LIKE %:name%", nativeQuery = true)
    List<Brand> search2(String name);

    // b => Brand
    // expected => GetBrandListResponse
    @Query("SELECT new com.example.springProjectTobeto.services.dtos.responses.brand.GetBrandListResponse(b.name) " +
            "FROM Brand b Where b.name LIKE %:name%")
    List<GetBrandListResponse> search3(String name);


}
