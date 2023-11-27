package com.example.springProjectTobeto.controllers;

import com.example.springProjectTobeto.services.dtos.requests.company.AddCompanyRequest;
import com.example.springProjectTobeto.services.dtos.requests.company.UpdateCompanyRequest;
import com.example.springProjectTobeto.services.dtos.responses.company.GetCompanyResponse;
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

        dto.setName(company.getName());
        dto.setContactName(company.getContactName());
        dto.setContactPhone(company.getContactPhone());
        dto.setAddress(company.getAddress());

        return dto;
    }

    @PostMapping
    public void add(@RequestBody AddCompanyRequest companyForAddDto) {

        Company company = new Company();

        company.setName(companyForAddDto.getName());
        company.setContactName(companyForAddDto.getContactName());
        company.setContactPhone(companyForAddDto.getContactPhone());
        company.setAddress(companyForAddDto.getAddress());
        company.setIsActive(companyForAddDto.getIsActive());
        company.setRank(companyForAddDto.getRank());

        companyRepository.save(company);
    }

    @PutMapping("{id}")
    public void updateCompany(@PathVariable int id, @RequestBody UpdateCompanyRequest companyForUpdateDto){
      Company updateCompany = companyRepository.findById(id)
              .orElseThrow(()-> new RuntimeException("There is no company id"));
        updateCompany.setName(companyForUpdateDto.getName());
        updateCompany.setContactName(companyForUpdateDto.getContactName());
        updateCompany.setContactPhone(companyForUpdateDto.getContactPhone());
        updateCompany.setAddress(companyForUpdateDto.getAddress());



      companyRepository.save(updateCompany);
    }

    @DeleteMapping("{id}")
    public void deleteCompany(@PathVariable int id){
        Company deleteCompany = companyRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("There is no company id"));
        companyRepository.delete(deleteCompany);
    }
}
