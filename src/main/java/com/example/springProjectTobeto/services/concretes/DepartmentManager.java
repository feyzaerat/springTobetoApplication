package com.example.springProjectTobeto.services.concretes;

import com.example.springProjectTobeto.entities.Department;
import com.example.springProjectTobeto.repositories.DepartmentRepository;
import com.example.springProjectTobeto.services.abstracts.DepartmentService;
import com.example.springProjectTobeto.services.dtos.requests.department.AddDepartmentRequest;
import com.example.springProjectTobeto.services.dtos.requests.department.UpdateDepartmentRequest;
import com.example.springProjectTobeto.services.dtos.responses.department.GetDepartmentResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@AllArgsConstructor
@Service
public class DepartmentManager implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Override
    public List<Department> getAll(){
        return departmentRepository.findAll();
    }
    @Override
    public GetDepartmentResponse getById(int id){
        Department department = departmentRepository.findById(id).orElseThrow();

        GetDepartmentResponse dto = new GetDepartmentResponse();
        dto.setName(department.getName());

        return dto;
    }

    public void addDepartment(AddDepartmentRequest addDepartmentRequest){
        Department department = new Department();

        department.setName(addDepartmentRequest.getName());
        departmentRepository.save(department);
    }
    @Override
    public void updateDepartment(@PathVariable int id, UpdateDepartmentRequest requestUpdate){
        Department updateDepartment = departmentRepository.findById(id).orElseThrow();
        updateDepartment.setName(requestUpdate.getName());

        departmentRepository.save(updateDepartment);
    }

    @Override
    public void deleteDepartment(int id){
        this.departmentRepository.deleteById(id);
    }

}