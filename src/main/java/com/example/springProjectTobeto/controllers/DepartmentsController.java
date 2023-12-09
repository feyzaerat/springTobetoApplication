package com.example.springProjectTobeto.controllers;

import com.example.springProjectTobeto.services.abstracts.DepartmentService;
import com.example.springProjectTobeto.services.dtos.requests.department.AddDepartmentRequest;
import com.example.springProjectTobeto.services.dtos.requests.department.UpdateDepartmentRequest;
import com.example.springProjectTobeto.services.dtos.responses.department.GetDepartmentResponse;
import com.example.springProjectTobeto.entities.Department;
import com.example.springProjectTobeto.repositories.DepartmentRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/departments")
public class DepartmentsController {

    private final DepartmentService departmentService;

    public DepartmentsController(DepartmentService departmentService){
        this.departmentService = departmentService;
    }

    @GetMapping
    public List<Department> getDepartmentList(){
        return this.departmentService.getAll();
    }

    @GetMapping("{id}")
    public GetDepartmentResponse getById(@PathVariable int id){
       return this.departmentService.getById(id);
    }

    @PostMapping
    public void addDepartment(@RequestBody @Valid AddDepartmentRequest addDepartmentRequest){
        this.departmentService.addDepartment(addDepartmentRequest);
    }

    @PutMapping("{id}")
    public void updateDepartment(@PathVariable int id, @RequestBody UpdateDepartmentRequest updateDepartmentRequest){
        this.departmentService.updateDepartment(id,updateDepartmentRequest);
    }

    @DeleteMapping("{id}")
    public void deleteDepartment(@PathVariable int id){
        this.departmentService.deleteDepartment(id);
    }

}
