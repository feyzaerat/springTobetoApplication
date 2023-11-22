package com.example.springProjectTobeto.dtos.requests.department;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddDepartmentRequest {
    private String name;
    private int isActive;
    private int rank;
}
