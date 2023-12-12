package com.example.springProjectTobeto.services.abstracts;

import com.example.springProjectTobeto.entities.Department;
import com.example.springProjectTobeto.services.dtos.requests.department.AddDepartmentRequest;
import com.example.springProjectTobeto.services.dtos.requests.department.UpdateDepartmentRequest;
import com.example.springProjectTobeto.services.dtos.responses.department.GetDepartmentListResponse;
import com.example.springProjectTobeto.services.dtos.responses.department.GetDepartmentResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface DepartmentService {

    List<Department> getAll();

    GetDepartmentResponse getById(int id);
<<<<<<< HEAD
    void addDepartment( AddDepartmentRequest addDepartmentRequest);
=======

    void addDepartment(AddDepartmentRequest addDepartmentRequest);

>>>>>>> f144bca86c3fcdb3a669153a04492e6c8ab4c901
    void updateDepartment(@PathVariable int id, UpdateDepartmentRequest updateDepartmentRequest);

    void deleteDepartment(int id);

    List<GetDepartmentListResponse> getByName(String name);

    List<GetDepartmentListResponse> searchAsLike(String name);

}
