package com.example.springProjectTobeto.services.concretes;

import com.example.springProjectTobeto.entities.Brand;
import com.example.springProjectTobeto.repositories.BrandRepository;
import com.example.springProjectTobeto.services.abstracts.BrandService;
import com.example.springProjectTobeto.services.dtos.requests.brand.AddBrandRequest;
import com.example.springProjectTobeto.services.dtos.requests.brand.UpdateBrandRequest;
import com.example.springProjectTobeto.services.dtos.responses.brand.GetBrandResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service

public class BrandManager implements BrandService {
    private final BrandRepository brandRepository;

    @Override
    public List<Brand> getAll(){
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
    public void addBrand(AddBrandRequest request){
        if(request.getName().length() < 2 ){
            throw new RuntimeException("The Brand Can not be short than 2 letters !!!");
        }

        Brand brand = new Brand();
        brand.setName(request.getName());

        brandRepository.save(brand);
    }

    @Override
    public void updateBrand(UpdateBrandRequest request) {
        Brand updateBrand = new Brand();
        updateBrand.setName(request.getName());

        brandRepository.save(updateBrand);
    }
    @Override
    public void deleteBrand(int id){
        this.brandRepository.deleteById(id);
    }
}
