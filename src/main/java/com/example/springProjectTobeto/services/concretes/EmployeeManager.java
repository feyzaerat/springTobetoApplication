package com.example.springProjectTobeto.services.concretes;

import com.example.springProjectTobeto.entities.Employee;
import com.example.springProjectTobeto.repositories.EmployeeRepository;
import com.example.springProjectTobeto.services.abstracts.EmployeeService;
import com.example.springProjectTobeto.services.dtos.requests.employee.AddEmployeeRequest;
import com.example.springProjectTobeto.services.dtos.requests.employee.UpdateEmployeeRequest;
import com.example.springProjectTobeto.services.dtos.responses.employee.GetEmployeeResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@AllArgsConstructor
@Service

public class EmployeeManager implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Override
    public List <Employee> getAll(){
        return this.employeeRepository.findAll();
    }
    @Override
    public GetEmployeeResponse getById(int id){
        Employee employee = employeeRepository.findById(id).orElseThrow();

        GetEmployeeResponse dto = new GetEmployeeResponse();
        dto.setFullName(employee.getFullName());
        dto.setMailAddress(employee.getMailAddress());
        dto.setPhoneNumber(employee.getPhoneNumber());
        dto.setAddress(employee.getAddress());

        return dto;
    }
    @Override
    public void addEmployee(AddEmployeeRequest addEmployeeRequest){
        boolean resultMail = employeeRepository.existsByMailAddress(addEmployeeRequest.getMailAddress().trim());
        if(resultMail){
            throw new RuntimeException("The mail address has to be unique !!!");
        }
        boolean resultPhone = employeeRepository.existsByPhoneNumber(addEmployeeRequest.getMailAddress().trim());
        if(resultPhone){
            throw new RuntimeException("The mail address has to be unique !!!");
        }

        Employee addEmployee = new Employee();
        addEmployee.setFullName(addEmployeeRequest.getFullName());
        addEmployee.setMailAddress(addEmployeeRequest.getMailAddress());
        addEmployee.setPhoneNumber(addEmployeeRequest.getPhoneNumber());
        addEmployee.setAddress(addEmployeeRequest.getAddress());

        employeeRepository.save(addEmployee);
    }
    @Override
    public void updateEmployee(@PathVariable int id, UpdateEmployeeRequest updateEmployeeRequest){
        Employee updateEmployee = employeeRepository.findById(id).orElseThrow();
        updateEmployee.setFullName(updateEmployeeRequest.getFullName());
        updateEmployee.setMailAddress(updateEmployeeRequest.getMailAddress());
        updateEmployee.setPhoneNumber(updateEmployeeRequest.getPhoneNumber());
        updateEmployee.setAddress(updateEmployeeRequest.getAddress());

        this.employeeRepository.save(updateEmployee);
    }
    @Override
    public void deleteEmployee(int id){
        this.employeeRepository.findById(id).orElseThrow();
        this.employeeRepository.deleteById(id);
    }
}
