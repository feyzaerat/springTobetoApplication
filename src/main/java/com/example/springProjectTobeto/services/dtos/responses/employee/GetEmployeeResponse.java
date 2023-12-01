package com.example.springProjectTobeto.services.dtos.responses.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetEmployeeResponse {
    private String fullName;
    private String phoneNumber;
    private String mailAddress;
    private String address;

}
