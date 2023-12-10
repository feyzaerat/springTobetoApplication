package com.example.springProjectTobeto.services.abstracts;

import com.example.springProjectTobeto.entities.Employee;
import com.example.springProjectTobeto.services.dtos.requests.customer.UpdateCustomerRequest;
import com.example.springProjectTobeto.services.dtos.requests.employee.AddEmployeeRequest;
import com.example.springProjectTobeto.services.dtos.requests.employee.UpdateEmployeeRequest;
import com.example.springProjectTobeto.services.dtos.responses.employee.GetEmployeeListResponse;
import com.example.springProjectTobeto.services.dtos.responses.employee.GetEmployeeResponse;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface EmployeeService {
    List <Employee> getAll();
    GetEmployeeResponse getById(int id);
    void addEmployee(AddEmployeeRequest addEmployeeRequest);
    void updateEmployee(@PathVariable int id, UpdateEmployeeRequest updateEmployeeRequest);
    void deleteEmployee(int id);

    List<GetEmployeeListResponse> getByName(String fullName);

}
