package com.example.springProjectTobeto.services.dtos.requests.company;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCompanyRequest {
    @NotBlank(message = "Company name can not be empty !")
    private String name;
    private String contactName;
    @Length(min = 10, max=10, message = "Phone number must be 10 digits !!")
    private String contactPhone;
    private String address;

}
