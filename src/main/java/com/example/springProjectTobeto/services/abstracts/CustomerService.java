package com.example.springProjectTobeto.services.abstracts;

import com.example.springProjectTobeto.entities.Customer;
import com.example.springProjectTobeto.services.dtos.requests.customer.AddCustomerRequest;
import com.example.springProjectTobeto.services.dtos.requests.customer.UpdateCustomerRequest;
import com.example.springProjectTobeto.services.dtos.responses.customer.GetCustomerListResponse;
import com.example.springProjectTobeto.services.dtos.responses.customer.GetCustomerResponse;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface CustomerService {
    List<Customer> getAll();
    List<GetCustomerListResponse> getByAddress(String address);
    GetCustomerResponse getById(int id);
    void addCustomer(AddCustomerRequest addCustomerRequest);
    void updateCustomer(@PathVariable int id, UpdateCustomerRequest updateCustomerRequest);
    void deleteCustomer(int id);

}
