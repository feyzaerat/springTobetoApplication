package com.example.springProjectTobeto.controllers;

import com.example.springProjectTobeto.dtos.responses.company.GetCompanyResponse;
import com.example.springProjectTobeto.entities.Company;
import com.example.springProjectTobeto.repositories.CompanyRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("api/companies")
public class CompaniesController {
    private final CompanyRepository companyRepository;

    public CompaniesController(CompanyRepository companyRepository){
        this.companyRepository = companyRepository;
    }

    @GetMapping
    public List<Company> getAll(){return companyRepository.findAll();}

    @GetMapping("{id}")
    public GetCompanyResponse getById(@PathVariable int id){
        Company company = companyRepository.findById(id).orElseThrow();

        GetCompanyResponse dto = new GetCompanyResponse();
        return dto;
    }

    @PostMapping
    public void add(@RequestBody Company company){
        companyRepository.save(company);
    }

    @PutMapping("{id}")
    public void updateCompany(@PathVariable int id, @RequestBody Company company){
      Company updateCompany = companyRepository.findById(id)
              .orElseThrow(()-> new RuntimeException("There is no company id"));
        updateCompany.setId(company.getId());
        updateCompany.setName(company.getName());
        updateCompany.setContactName(company.getContactName());
        updateCompany.setContactPhone(company.getContactPhone());
        updateCompany.setAddress(company.getAddress());



      companyRepository.save(updateCompany);
    }

    @DeleteMapping("{id}")
    public void deleteCompany(@PathVariable int id){
        Company deleteCompany = companyRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("There is no company id"));
        companyRepository.delete(deleteCompany);
    }
}
