package com.example.springProjectTobeto.services.abstracts;

import com.example.springProjectTobeto.entities.Company;
import com.example.springProjectTobeto.services.dtos.requests.car.UpdateCarRequest;
import com.example.springProjectTobeto.services.dtos.requests.company.AddCompanyRequest;
import com.example.springProjectTobeto.services.dtos.requests.company.UpdateCompanyRequest;
import com.example.springProjectTobeto.services.dtos.responses.company.GetCompanyResponse;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface CompanyService {

    List <Company> getAll();
    GetCompanyResponse getById(int id);
    void addCompany(AddCompanyRequest addCompanyRequest);
    void updateCompany(@PathVariable int id, UpdateCompanyRequest updateCompanyRequest);
    void deleteCompany(int id);
}
