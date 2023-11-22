package com.example.springProjectTobeto.controllers;

import com.example.springProjectTobeto.entities.Department;
import com.example.springProjectTobeto.repositories.DepartmentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/departments")
public class DepartmentsController {

    private final DepartmentRepository departmentRepository;

    public DepartmentsController(DepartmentRepository departmentRepository){
        this.departmentRepository = departmentRepository;
    }

    @GetMapping
    public List<Department> getAll(){
        return departmentRepository.findAll();
    }

    @GetMapping("{id}")
    public Department getById(@PathVariable int id){
        return departmentRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Department department){
        departmentRepository.save(department);
    }

    @PutMapping("{id}")
    public void updateDepartment(@PathVariable int id, @RequestBody Department department){
        Department updateDepartment = departmentRepository.findById(id)
                .orElseThrow(()->new RuntimeException("There is no department"));
        updateDepartment.setId(department.getId());
        updateDepartment.setName(department.getName());
        updateDepartment.setRank(department.getRank());
        updateDepartment.setIsActive(department.getIsActive());

        departmentRepository.save(updateDepartment);
    }

    @DeleteMapping("{id}")
    public void deleteDepartment(@PathVariable int id){
        Department deleteDepartment = departmentRepository.findById(id)
                .orElseThrow(()->new RuntimeException("There is no id"));
        departmentRepository.delete(deleteDepartment);
    }

}
