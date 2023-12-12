package com.example.springProjectTobeto.services.dtos.requests.department;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddDepartmentRequest {
    @NotBlank(message = "You must enter the Brand Name !! ")
    private String name;
    private int isActive;
    private int rank;
}
