package com.example.springProjectTobeto.controllers;

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
    public Brand getById(@PathVariable  int id){
        return brandRepository.findById(id).orElseThrow();
    }
    @PostMapping
    public void add(@RequestBody Brand brand){
        brandRepository.save(brand);
    }
    @PutMapping
    public void update(@RequestBody Brand brand) {

    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id)
    {
        // kod buraya geliyor ise exception fırlamamıştır..
        //Brand brandToDelete = brandRepository.findById(id).orElseThrow();
        // özel kontroller
        //brandRepository.delete(brandToDelete);
        brandRepository.deleteById(id);
    }
}