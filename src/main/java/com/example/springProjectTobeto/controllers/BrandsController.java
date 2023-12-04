package com.example.springProjectTobeto.controllers;

import com.example.springProjectTobeto.services.abstracts.BrandService;
import com.example.springProjectTobeto.services.dtos.requests.brand.AddBrandRequest;
import com.example.springProjectTobeto.services.dtos.requests.brand.UpdateBrandRequest;
import com.example.springProjectTobeto.services.dtos.responses.brand.GetBrandListResponse;
import com.example.springProjectTobeto.services.dtos.responses.brand.GetBrandResponse;
import com.example.springProjectTobeto.entities.Brand;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/brands")

public class BrandsController {
    private final BrandService brandService;
    public BrandsController(BrandService brandService){
        this.brandService = brandService;
    }
   /*@GetMapping
    public List<Brand> getBrandList() {
        return this.brandService.getAll();
    }*/
    @GetMapping("{id}")
    public GetBrandResponse getById(@PathVariable int id) {
        return this.brandService.getById(id);
    }
    @PostMapping
    public void addBrand(@RequestBody AddBrandRequest addBrandRequest){
        this.brandService.addBrand(addBrandRequest);
    }
    @PutMapping("{id}")
    public void updateBrand(@PathVariable int id, @RequestBody UpdateBrandRequest updateBrandRequest) throws Exception {
         this.brandService.updateBrand(id, updateBrandRequest);

    }
    @DeleteMapping("{id}")
    public void deleteBand(@PathVariable int id) {
         this.brandService.deleteBrand(id);

    }
    @GetMapping("getName")
    public List<GetBrandListResponse> getByName(@RequestParam String name, @RequestParam int id)
    {
        return this.brandService.getByName(name,id);
    }


    @GetMapping("search")
    public List<Brand> search(@RequestParam String name){
        return this.brandService.search(name);
    }

}