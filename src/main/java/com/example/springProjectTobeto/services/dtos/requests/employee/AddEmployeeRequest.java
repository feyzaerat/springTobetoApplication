package com.example.springProjectTobeto.services.dtos.requests.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddEmployeeRequest {
    private String fullName;
    @Length(min = 10, max = 10, message = "The phone number must be 10 digits !")
    private String phoneNumber;
    private String mailAddress;
    private String address;


}
