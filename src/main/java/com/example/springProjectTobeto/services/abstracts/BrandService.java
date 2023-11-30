package com.example.springProjectTobeto.services.abstracts;

import com.example.springProjectTobeto.entities.Brand;
import com.example.springProjectTobeto.services.dtos.requests.brand.AddBrandRequest;
import com.example.springProjectTobeto.services.dtos.requests.brand.UpdateBrandRequest;
import com.example.springProjectTobeto.services.dtos.responses.brand.GetBrandResponse;

import java.util.List;

public interface BrandService {

    List<Brand> getAll();
    GetBrandResponse getById(int id);
    void addBrand(AddBrandRequest request);
    void updateBrand(UpdateBrandRequest request);
    void deleteBrand(int id);
}
