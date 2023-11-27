package com.example.springProjectTobeto.services.dtos.responses.department;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetDepartmentResponse {
    private String name;
    private int isActive;
    private int rank;
}
