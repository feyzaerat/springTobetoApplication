package com.example.springProjectTobeto.controllers;

import com.example.springProjectTobeto.entities.Employee;
import com.example.springProjectTobeto.services.abstracts.EmployeeService;
import com.example.springProjectTobeto.services.dtos.requests.employee.AddEmployeeRequest;
import com.example.springProjectTobeto.services.dtos.requests.employee.UpdateEmployeeRequest;
import com.example.springProjectTobeto.services.dtos.responses.employee.GetEmployeeListResponse;
import com.example.springProjectTobeto.services.dtos.responses.employee.GetEmployeeResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employees")
public class EmployeesController {

    private final EmployeeService employeeService;

    public EmployeesController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getEmployeeList() {
        return employeeService.getAll();
    }

    @GetMapping("{id}")
    public GetEmployeeResponse getById(@PathVariable int id) {
        return this.employeeService.getById(id);
    }


    @PostMapping
    public void addEmployee(@RequestBody @Valid AddEmployeeRequest addEmployeeRequest) {
        this.employeeService.addEmployee(addEmployeeRequest);
    }

    @PutMapping("{id}")
    public void updateEmployee(@PathVariable int id, @RequestBody UpdateEmployeeRequest updateEmployeeRequest) {
        this.employeeService.updateEmployee(id, updateEmployeeRequest);
    }

    @DeleteMapping("{id}")
    public void deleteEmployee(@PathVariable int id) {
        this.employeeService.deleteEmployee(id);
    }

    @GetMapping("getByName")
    public List<GetEmployeeListResponse> getByName(@RequestParam String fullName) {
        return this.employeeService.getByName(fullName);
    }

    @GetMapping("searchAsLike")
    public List<GetEmployeeListResponse> searchAsLike(@RequestParam String fullName){
        return this.employeeService.searchAsLike(fullName);
    }
}
