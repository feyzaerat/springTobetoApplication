package com.example.springProjectTobeto.dtos.requests.department;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UpdateDepartmentRequest {
    private String name;
}
