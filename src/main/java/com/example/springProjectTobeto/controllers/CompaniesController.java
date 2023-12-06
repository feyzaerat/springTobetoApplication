package com.example.springProjectTobeto.controllers;

import com.example.springProjectTobeto.services.abstracts.CompanyService;
import com.example.springProjectTobeto.services.dtos.requests.company.AddCompanyRequest;
import com.example.springProjectTobeto.services.dtos.requests.company.UpdateCompanyRequest;
import com.example.springProjectTobeto.services.dtos.responses.company.GetCompanyListResponse;
import com.example.springProjectTobeto.services.dtos.responses.company.GetCompanyResponse;
import com.example.springProjectTobeto.entities.Company;
import com.example.springProjectTobeto.repositories.CompanyRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("api/companies")
public class CompaniesController {
    private final CompanyService companyService;

    public CompaniesController(CompanyService companyService){

        this.companyService = companyService;
    }

    @GetMapping
    public List<Company> getCompanyList(){
        return this.companyService.getAll();
    }

    @GetMapping("{id}")
    public GetCompanyResponse getById(@PathVariable int id){
       return this.companyService.getById(id);
    }

    @PostMapping
    public void addCompany(@RequestBody AddCompanyRequest addCompanyRequest) {
        this.companyService.addCompany(addCompanyRequest);
    }

    @PutMapping("{id}")
    public void updateCompany(@PathVariable int id, @RequestBody UpdateCompanyRequest updateCompanyRequest){
      this.companyService.updateCompany(id,updateCompanyRequest);
    }

    @DeleteMapping("{id}")
    public void deleteCompany(@PathVariable int id){
        this.companyService.deleteCompany(id);
    }

    @GetMapping("getByName")
    public List<GetCompanyListResponse> getByName(@RequestParam String name, @RequestParam int id){
        return this.companyService.getByName(name,id);
    }
}
