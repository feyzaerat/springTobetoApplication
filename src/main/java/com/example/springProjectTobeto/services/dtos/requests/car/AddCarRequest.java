package com.example.springProjectTobeto.services.dtos.requests.car;

import com.example.springProjectTobeto.entities.Brand;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCarRequest {

    @NotBlank(message = "You must enter the model name !!")
    private String modelName;
    private int modelYear;
    /*private Brand id;*/


}
