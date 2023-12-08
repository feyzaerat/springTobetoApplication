package com.example.springProjectTobeto.services.concretes;

import com.example.springProjectTobeto.entities.Company;
import com.example.springProjectTobeto.repositories.CompanyRepository;
import com.example.springProjectTobeto.services.abstracts.CompanyService;
import com.example.springProjectTobeto.services.dtos.requests.company.AddCompanyRequest;
import com.example.springProjectTobeto.services.dtos.requests.company.UpdateCompanyRequest;
import com.example.springProjectTobeto.services.dtos.responses.company.GetCompanyListResponse;
import com.example.springProjectTobeto.services.dtos.responses.company.GetCompanyResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class CompanyManager implements CompanyService {
    private final CompanyRepository companyRepository;

    @Override
    public List<Company> getAll(){
        return companyRepository.findAll();
    }
    @Override
    public GetCompanyResponse getById(int id) throws RuntimeException{
        Company company = companyRepository.findById(id)
                .orElseThrow(()->new RuntimeException("There is no any company with this ID"));

        GetCompanyResponse dto = new GetCompanyResponse();
        dto.setName(company.getName());
        dto.setContactName(company.getContactName());
        dto.setContactPhone(company.getContactPhone());
        dto.setAddress(company.getAddress());

        return dto;
    }
    @Override
    public void addCompany(AddCompanyRequest addCompanyRequest){
        Company company = new Company();

        company.setName(addCompanyRequest.getName());
        company.setContactName(addCompanyRequest.getContactName());
        company.setContactPhone(addCompanyRequest.getContactPhone());
        company.setAddress(addCompanyRequest.getAddress());

        this.companyRepository.save(company);
    }
    @Override
    public void updateCompany(@PathVariable int id, UpdateCompanyRequest updateCompanyRequest) throws RuntimeException{
        Company updateCompany = companyRepository.findById(id)
                .orElseThrow(()->new RuntimeException("There is no any company with this ID"));
        updateCompany.setName(updateCompanyRequest.getName());
        updateCompany.setContactName(updateCompanyRequest.getContactName());
        updateCompany.setContactPhone(updateCompanyRequest.getContactPhone());
        updateCompany.setAddress(updateCompanyRequest.getAddress());

        this.companyRepository.save(updateCompany);
    }
    @Override
    public void deleteCompany(int id)throws RuntimeException{
        Company deleteCompany = companyRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Delete Failed !! There is no any Company with this ID"));
        this.companyRepository.deleteById(id);
    }

    public List<GetCompanyListResponse>getByName(String name, int id){
        List<Company> companies = companyRepository.findByNameLikeOrIdEquals("%" + name + "%", id);
        List<GetCompanyListResponse> response = new ArrayList<>();

        for(Company company: companies){
            response.add(new GetCompanyListResponse(company.getName()));
        }
        return response;

    }

}
