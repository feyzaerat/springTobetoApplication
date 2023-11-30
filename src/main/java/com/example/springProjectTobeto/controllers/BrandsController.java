package com.example.springProjectTobeto.controllers;

import com.example.springProjectTobeto.services.abstracts.BrandService;
import com.example.springProjectTobeto.services.dtos.requests.brand.AddBrandRequest;
import com.example.springProjectTobeto.services.dtos.requests.brand.UpdateBrandRequest;
import com.example.springProjectTobeto.services.dtos.responses.brand.GetBrandResponse;
import com.example.springProjectTobeto.entities.Brand;
import com.example.springProjectTobeto.repositories.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/brands")

public class BrandsController {
    private final BrandService brandService;

    public BrandsController(BrandService brandService){
        this.brandService = brandService;
    }
   @GetMapping
    public List<Brand> getBrandList() {
        return  this.brandService.getAll().reversed();
    }

    @GetMapping("{id}")
    public GetBrandResponse getById(@PathVariable int id) {
        return this.brandService.getById(id);
    }
    @PostMapping
    public void addBrand(@RequestBody AddBrandRequest request){
        this.brandService.addBrand(request);
    }

    @PutMapping("{id}")
    public void updateBrand(@PathVariable int id, @RequestBody UpdateBrandRequest request) {
         this.brandService.updateBrand(request);

    }
    @DeleteMapping("{id}")
    public void deleteBand(@PathVariable int id) {
         this.brandService.deleteBrand(id);

    }
}