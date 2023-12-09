package com.example.springProjectTobeto.services.dtos.requests.customer;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCustomerRequest {

    @NotBlank(message = "You must enter the Customer Name !! ")
    private String name;
    @Length(min=10, max=10, message = "The phone number  must be between of 10  digits !")
    private String phone;
    private String mailAddress;
    private String address;

}
