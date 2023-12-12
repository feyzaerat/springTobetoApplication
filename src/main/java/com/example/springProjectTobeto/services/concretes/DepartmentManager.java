package com.example.springProjectTobeto.services.concretes;

import com.example.springProjectTobeto.entities.Brand;
import com.example.springProjectTobeto.entities.Department;
import com.example.springProjectTobeto.repositories.DepartmentRepository;
import com.example.springProjectTobeto.services.abstracts.DepartmentService;
import com.example.springProjectTobeto.services.dtos.requests.brand.AddBrandRequest;
import com.example.springProjectTobeto.services.dtos.requests.department.AddDepartmentRequest;
import com.example.springProjectTobeto.services.dtos.requests.department.UpdateDepartmentRequest;
import com.example.springProjectTobeto.services.dtos.responses.department.GetDepartmentListResponse;
import com.example.springProjectTobeto.services.dtos.responses.department.GetDepartmentResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class DepartmentManager implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Override
    public List<Department> getAll() {
        return departmentRepository.findAll();
    }

    @Override
    public GetDepartmentResponse getById(int id) {
        Department department = departmentRepository.findById(id).orElseThrow();

        GetDepartmentResponse dto = new GetDepartmentResponse();
        dto.setName(department.getName());


        return dto;
    }

<<<<<<< HEAD
    /*public void addDepartment(AddDepartmentRequest addDepartmentRequest){
=======
    public void addDepartment(AddDepartmentRequest addDepartmentRequest) {
        boolean result = departmentRepository.existsByName(addDepartmentRequest.getName().trim());

        if (result) {
            throw new RuntimeException("The Brand Name has to be Unique !!");
        }
>>>>>>> f144bca86c3fcdb3a669153a04492e6c8ab4c901
        Department department = new Department();

        department.setName(addDepartmentRequest.getName());
        departmentRepository.save(department);
    }*/

    @Override
    public void addDepartment(AddDepartmentRequest addDepartmentRequest){

        boolean result = departmentRepository.existsByName(addDepartmentRequest.getName().trim());

        if(result){
            throw new RuntimeException("The Department Name has to be Unique !!");
        }
        Department department = new Department();
        department.setName(addDepartmentRequest.getName());

        departmentRepository.save(department);
    }

    @Override
    public void updateDepartment(@PathVariable int id, UpdateDepartmentRequest requestUpdate) {
        Department updateDepartment = departmentRepository.findById(id).orElseThrow();
        updateDepartment.setName(requestUpdate.getName());

        departmentRepository.save(updateDepartment);
    }

    @Override
    public void deleteDepartment(int id) {
        this.departmentRepository.deleteById(id);
    }

    @Override
    public List<GetDepartmentListResponse> getByName(String name) {
        List<Department> departments = departmentRepository.findByNameLike("%" + name + "%");
        List<GetDepartmentListResponse> response = new ArrayList<>();

        for (Department department : departments) {
            response.add(new GetDepartmentListResponse(department.getName()));
        }
        return response;
    }

    @Override
    public List<GetDepartmentListResponse> searchAsLike(String name){
        List<Department> departments = departmentRepository.searchAsValue(name);

        return departmentRepository.searchAsList(name);
    }

}
