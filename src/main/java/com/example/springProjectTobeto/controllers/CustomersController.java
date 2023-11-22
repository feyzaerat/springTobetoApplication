package com.example.springProjectTobeto.controllers;

import com.example.springProjectTobeto.dtos.requests.customer.AddCustomerRequest;
import com.example.springProjectTobeto.dtos.requests.customer.UpdateCustomerRequest;
import com.example.springProjectTobeto.dtos.responses.customer.GetCustomerResponse;
import com.example.springProjectTobeto.entities.Customer;
import com.example.springProjectTobeto.repositories.CustomerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/customers")
public class CustomersController {
    private final CustomerRepository customerRepository;

    public CustomersController(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @GetMapping
    public List<Customer> getAll(){
        return customerRepository.findAll();
    }

    @GetMapping("{id}")
    public GetCustomerResponse getById(@PathVariable int id){
        Customer customer = customerRepository.findById(id)
                .orElseThrow(()->new RuntimeException("There is no id"));
        GetCustomerResponse dto = new GetCustomerResponse();
        dto.setName(customer.getName());
        dto.setPhone(customer.getPhone());
        dto.setMailAddress(customer.getMailAddress());
        dto.setAddress(customer.getAddress());

        return dto;
    }

    @PostMapping
    public void addCustomer(@RequestBody AddCustomerRequest customerForAddDto) {

        Customer customer = new Customer();
        customer.setName(customerForAddDto.getName());
        customer.setPhone(customerForAddDto.getPhone());
        customer.setMailAddress(customerForAddDto.getMailAddress());
        customer.setAddress(customerForAddDto.getAddress());
        customer.setIsActive(customerForAddDto.getIsActive());
        customer.setRank(customerForAddDto.getRank());

        customerRepository.save(customer);
    }

    @PutMapping("{id}")
    public void updateCustomer(@PathVariable int id, @RequestBody UpdateCustomerRequest customerForUpdateDto){
        Customer updateCustomer = customerRepository.findById(id)
                .orElseThrow(()->new RuntimeException("There is no id"));
        updateCustomer.setName(customerForUpdateDto.getName());
        updateCustomer.setPhone(customerForUpdateDto.getPhone());
        updateCustomer.setMailAddress(customerForUpdateDto.getMailAddress());
        updateCustomer.setAddress(customerForUpdateDto.getAddress());

        customerRepository.save(updateCustomer);
    }

   @DeleteMapping("{id}")
    public void deleteCustomer(@PathVariable int id){
        Customer deleteCustomer = customerRepository.findById(id)
                .orElseThrow(()->new RuntimeException("there is no id"));
        customerRepository.delete(deleteCustomer);
   }
}
