package com.example.springProjectTobeto.services.abstracts;

import com.example.springProjectTobeto.services.dtos.requests.brand.AddBrandRequest;
import com.example.springProjectTobeto.services.dtos.responses.brand.GetBrandResponse;

public interface BrandService {
    void add(AddBrandRequest request);
    GetBrandResponse getById(int id);
}
