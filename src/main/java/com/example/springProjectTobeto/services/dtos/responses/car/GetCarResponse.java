package com.example.springProjectTobeto.services.dtos.responses.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCarResponse {

    private String modelName;
    private String modelYear;
    private int isActive;
    private int rank;
}
