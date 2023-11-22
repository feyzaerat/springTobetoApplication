package com.example.springProjectTobeto.dtos.requests.brand;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UpdateBrandRequest {
    private String modelName;
    private String modelYear;
    private int isActive;
}
