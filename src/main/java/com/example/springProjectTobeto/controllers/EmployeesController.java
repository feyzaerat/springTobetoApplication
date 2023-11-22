package com.example.springProjectTobeto.controllers;

import com.example.springProjectTobeto.repositories.EmployeeRepository;
import com.example.springProjectTobeto.entities.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employees")
public class EmployeesController {

    private final EmployeeRepository employeeRepository;

    public EmployeesController(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @GetMapping
    public List<Employee> getAll(){return employeeRepository.findAll();}

    @GetMapping("{id}")
    public Employee getbyId(@PathVariable int id) {
        return employeeRepository.findById(id).orElseThrow();
    }


    @PostMapping
    public void add(@RequestBody Employee employee){employeeRepository.save(employee);}

    @PutMapping("{id}")
    public void update(@PathVariable int id,@RequestBody Employee employee){
        Employee updateEmployee = employeeRepository.findById(id)
                .orElseThrow(()->new RuntimeException("there is no Employee"));
        updateEmployee.setId(employee.getId());
        updateEmployee.setFullName(employee.getFullName());
        updateEmployee.setAddress(employee.getAddress());
        updateEmployee.setMailAddress(employee.getMailAddress());
        updateEmployee.setPhoneNumber(employee.getPhoneNumber());
        updateEmployee.setIsActive(employee.getIsActive());
        updateEmployee.setRank(employee.getRank());
        updateEmployee.setDepartment(employee.getDepartment());

        employeeRepository.save(updateEmployee);

    }

    @DeleteMapping("{id}")
    public void deleteEmployee(@PathVariable int id){
        Employee deleteEmployee = employeeRepository.findById(id)
                .orElseThrow(()->new RuntimeException("There is no id"));
        employeeRepository.delete(deleteEmployee);
    }

}
