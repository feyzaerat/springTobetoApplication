package com.example.springProjectTobeto.services.dtos.requests.brand;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddBrandRequest {

    @NotBlank(message = "You must enter the Brand Name !! ")
    @Length(min=3, max=20, message = "The brand name must be between of 3 and 20  digits !")
    private String name;

    private int isActive;
    private int rank;
}