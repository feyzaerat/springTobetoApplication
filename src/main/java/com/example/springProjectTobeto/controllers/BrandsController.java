package com.example.springProjectTobeto.controllers;

import com.example.springProjectTobeto.entities.Brand;
import com.example.springProjectTobeto.repositories.BrandRepository;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
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
    public Brand getById(@PathVariable  int id){
        return brandRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("There is no brand id"));
    }
    @PostMapping
    public void add(@RequestBody Brand brand){
        brandRepository.save(brand);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody Brand brand) {
        Brand updateBrand = brandRepository.findById(id).orElseThrow();
        updateBrand.setId(brand.getId());
        updateBrand.setName(brand.getName());
        brandRepository.save(updateBrand);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        Brand deleteBrand = brandRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("There is no brand id"));
        brandRepository.delete(deleteBrand);
    }
}