package com.example.springProjectTobeto.controllers;

import com.example.springProjectTobeto.services.abstracts.CustomerService;
import com.example.springProjectTobeto.services.dtos.requests.customer.AddCustomerRequest;
import com.example.springProjectTobeto.services.dtos.requests.customer.UpdateCustomerRequest;
import com.example.springProjectTobeto.services.dtos.responses.customer.GetCustomerResponse;
import com.example.springProjectTobeto.entities.Customer;
import com.example.springProjectTobeto.repositories.CustomerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/customers")
public class CustomersController {
    private final CustomerService customerService;

    public CustomersController(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getCustomerList(){
        return customerService.getAll();
    }

    @GetMapping("{id}")
    public GetCustomerResponse getById(@PathVariable int id){
       return this.customerService.getById(id);
    }

    @PostMapping
    public void addCustomer(@RequestBody AddCustomerRequest addCustomerRequest) {
        this.customerService.addCustomer(addCustomerRequest);
    }

    @PutMapping("{id}")
    public void updateCustomer(@PathVariable int id, @RequestBody UpdateCustomerRequest updateCustomerRequest){
       this.customerService.updateCustomer(id,updateCustomerRequest);
    }

   @DeleteMapping("{id}")
    public void deleteCustomer(@PathVariable int id){
        this.customerService.deleteCustomer(id);
   }
}
