package com.example.springProjectTobeto.services.concretes;

import com.example.springProjectTobeto.entities.Brand;
import com.example.springProjectTobeto.repositories.BrandRepository;
import com.example.springProjectTobeto.services.abstracts.BrandService;
import com.example.springProjectTobeto.services.dtos.requests.brand.AddBrandRequest;
import com.example.springProjectTobeto.services.dtos.requests.brand.UpdateBrandRequest;
import com.example.springProjectTobeto.services.dtos.responses.brand.GetBrandListResponse;
import com.example.springProjectTobeto.services.dtos.responses.brand.GetBrandResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service

public class BrandManager implements BrandService {
    private final BrandRepository brandRepository;

    @Override
    public List<Brand> getAll() {
        return brandRepository.findAll();
    }

    @Override
    public GetBrandResponse getById(int id) {
        Brand brand = brandRepository.findById(id).orElseThrow();

        GetBrandResponse dto = new GetBrandResponse();
        dto.setName(brand.getName());

        return dto;
    }

    @Override
    public void addBrand(AddBrandRequest addBrandRequest) {

        boolean result = brandRepository.existsByName(addBrandRequest.getName().trim());

        if (result) {
            throw new RuntimeException("The Brand Name has to be Unique !!");
        }
        Brand brand = new Brand();
        brand.setName(addBrandRequest.getName());

        brandRepository.save(brand);
    }

    @Override
    public void updateBrand(@PathVariable int id, UpdateBrandRequest updateBrandRequest) throws Exception {
        Brand updateBrand = brandRepository.findById(id).orElseThrow();
        updateBrand.setName(updateBrandRequest.getName());

        this.brandRepository.save(updateBrand);
    }

    @Override
    public void deleteBrand(int id) {
        this.brandRepository.deleteById(id);
    }

    @Override
    public List<GetBrandListResponse> getByName(String name, int id) {
        List<Brand> brands = brandRepository.findByNameLikeOrIdEquals("%" + name + "%", id);
        List<GetBrandListResponse> response = new ArrayList<>();

        for (Brand brand : brands) {
            response.add(new GetBrandListResponse(brand.getName()));
        }
        return response;
    }

    @Override
    public List<GetBrandListResponse> search(String name) {
        List<Brand> brands = brandRepository.search2(name);


        return brandRepository.search3(name);
    }


}
