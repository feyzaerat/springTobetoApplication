package com.example.springProjectTobeto.services.concretes;

import com.example.springProjectTobeto.entities.Customer;
import com.example.springProjectTobeto.repositories.CustomerRepository;
import com.example.springProjectTobeto.services.abstracts.CustomerService;
import com.example.springProjectTobeto.services.dtos.requests.customer.AddCustomerRequest;
import com.example.springProjectTobeto.services.dtos.requests.customer.UpdateCustomerRequest;
import com.example.springProjectTobeto.services.dtos.responses.company.GetCompanyResponse;
import com.example.springProjectTobeto.services.dtos.responses.customer.GetCustomerResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@AllArgsConstructor
@Service
public class CustomerManager implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public List <Customer> getAll(){
        return customerRepository.findAll();
    }
    @Override
    public GetCustomerResponse getById(int id){
        Customer customer = customerRepository.findById(id).orElseThrow();

        GetCustomerResponse dto = new GetCustomerResponse();
        dto.setName(customer.getName());
        dto.setMailAddress(customer.getMailAddress());
        dto.setPhone(customer.getPhone());
        dto.setAddress(customer.getAddress());

        return dto;
    }
    @Override
    public void addCustomer(AddCustomerRequest addCustomerRequest){
        boolean resultMail = customerRepository.existsByMailAddress(addCustomerRequest.getMailAddress().trim());

        if(resultMail){
            throw new RuntimeException("The Mail address has to be Unique !!");
        }
        boolean resultPhone = customerRepository.existsByPhone(addCustomerRequest.getPhone().trim());

        if(resultPhone){
            throw new RuntimeException("The Phone has to be Unique !!");
        }
        Customer addCustomer = new Customer();
        addCustomer.setName(addCustomerRequest.getName());
        addCustomer.setMailAddress(addCustomerRequest.getMailAddress());
        addCustomer.setPhone(addCustomerRequest.getPhone());
        addCustomer.setAddress(addCustomerRequest.getAddress());

        customerRepository.save(addCustomer);
    }
    @Override
    public void updateCustomer(@PathVariable int id, UpdateCustomerRequest updateCustomerRequest) throws RuntimeException{
        Customer updateCustomer = customerRepository.findById(id).orElseThrow(()->
                new RuntimeException("Update Failed !! There is no any customer with this ID"));
        updateCustomer.setName(updateCustomerRequest.getName());
        updateCustomer.setMailAddress(updateCustomerRequest.getMailAddress());
        updateCustomer.setPhone(updateCustomerRequest.getPhone());
        updateCustomer.setAddress(updateCustomerRequest.getAddress());

        this.customerRepository.save(updateCustomer);
    }
    @Override
    public void deleteCustomer(int id){
        this.customerRepository.findById(id).orElseThrow(()->
                new RuntimeException("Update Failed !! There is no any customer with this ID"));
        this.customerRepository.deleteById(id);
    }
}
