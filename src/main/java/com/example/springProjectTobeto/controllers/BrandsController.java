package com.example.springProjectTobeto.controllers;

import com.example.springProjectTobeto.services.dtos.requests.brand.AddBrandRequest;
import com.example.springProjectTobeto.services.dtos.requests.brand.UpdateBrandRequest;
import com.example.springProjectTobeto.services.dtos.responses.brand.GetBrandResponse;
import com.example.springProjectTobeto.entities.Brand;
import com.example.springProjectTobeto.repositories.BrandRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/brands")
public class BrandsController {

    private final BrandRepository brandRepository;

    public BrandsController(BrandRepository brandRepository){
        this.brandRepository = brandRepository;
    }

    @GetMapping
    public List<Brand> getAll() {
        return brandRepository.findAll();
    }

    @GetMapping("{id}")
    public GetBrandResponse getById(@PathVariable int id) {
        Brand brand = brandRepository.findById(id).orElseThrow();

        GetBrandResponse dto = new GetBrandResponse();
        dto.setName(brand.getName());

        return dto;
    }
    @PostMapping

    public void add(@RequestBody AddBrandRequest brandForAddDto){

        Brand brand = new Brand();
        brand.setName(brandForAddDto.getName());
        brand.setIsActive(brandForAddDto.getIsActive());
        brand.setRank(brandForAddDto.getRank());

        brandRepository.save(brand);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody UpdateBrandRequest brandForUpdateDto) {
        Brand updateBrand = brandRepository.findById(id).orElseThrow();

        updateBrand.setName(brandForUpdateDto.getName());

        brandRepository.save(updateBrand);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        Brand deleteBrand = brandRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("There is no brand id"));
        brandRepository.delete(deleteBrand);
    }
}