package com.example.springProjectTobeto.services.dtos.requests.car;

import com.example.springProjectTobeto.entities.Brand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCarRequest {

    private String modelName;
    private int modelYear;
    /*private Brand id;*/


}
