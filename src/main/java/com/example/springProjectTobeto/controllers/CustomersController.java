package com.example.springProjectTobeto.controllers;

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
        return dto;
    }

    @PostMapping
    public void addCustomer(@RequestBody Customer customer){
        customerRepository.save(customer);
    }

    @PutMapping("{id}")
    public void updateCustomer(@PathVariable int id, @RequestBody Customer customer){
        Customer updateCustomer = customerRepository.findById(id)
                .orElseThrow(()->new RuntimeException("There is no id"));
        updateCustomer.setId(customer.getId());
        updateCustomer.setName(customer.getName());
        updateCustomer.setPhone(customer.getPhone());
        updateCustomer.setMailAddress(customer.getMailAddress());
        updateCustomer.setAddress(customer.getAddress());
        updateCustomer.setRank(customer.getRank());
        updateCustomer.setIsActive(customer.getIsActive());

        customerRepository.save(updateCustomer);
    }

   @DeleteMapping("{id}")
    public void deleteCustomer(@PathVariable int id){
        Customer deleteCustomer = customerRepository.findById(id)
                .orElseThrow(()->new RuntimeException("there is no id"));
        customerRepository.delete(deleteCustomer);
   }
}
