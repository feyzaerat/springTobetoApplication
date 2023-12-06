package com.example.springProjectTobeto.services.abstracts;

import com.example.springProjectTobeto.entities.Brand;
import com.example.springProjectTobeto.services.dtos.requests.brand.AddBrandRequest;
import com.example.springProjectTobeto.services.dtos.requests.brand.UpdateBrandRequest;
import com.example.springProjectTobeto.services.dtos.responses.brand.GetBrandListResponse;
import com.example.springProjectTobeto.services.dtos.responses.brand.GetBrandResponse;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface BrandService {

    List<Brand> getAll();
    GetBrandResponse getById(int id);
    void addBrand(AddBrandRequest addBrandRequest);

    void updateBrand(@PathVariable int id, UpdateBrandRequest updateBrandRequest) throws Exception;

    void deleteBrand(int id);

    List<GetBrandListResponse> getByName(String name, int id);
    List<GetBrandListResponse> search(String name);
}
