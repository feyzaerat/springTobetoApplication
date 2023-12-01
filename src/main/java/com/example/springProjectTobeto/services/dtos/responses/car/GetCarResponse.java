package com.example.springProjectTobeto.services.dtos.responses.car;

import com.example.springProjectTobeto.entities.Brand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCarResponse {

    private String modelName;
    private int modelYear;
   /* private Brand id;*/

}
