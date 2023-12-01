package com.example.springProjectTobeto.services.abstracts;

import com.example.springProjectTobeto.entities.Department;
import com.example.springProjectTobeto.services.dtos.requests.department.AddDepartmentRequest;
import com.example.springProjectTobeto.services.dtos.requests.department.UpdateDepartmentRequest;
import com.example.springProjectTobeto.services.dtos.responses.department.GetDepartmentResponse;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface DepartmentService {

    List<Department> getAll();
    GetDepartmentResponse getById(int id);
    void addDepartment(AddDepartmentRequest addDepartmentRequest);
    void updateDepartment(@PathVariable int id, UpdateDepartmentRequest updateDepartmentRequest);
    void deleteDepartment(int id);

}
