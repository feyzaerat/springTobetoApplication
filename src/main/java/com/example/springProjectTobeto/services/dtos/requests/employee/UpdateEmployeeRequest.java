package com.example.springProjectTobeto.services.dtos.requests.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UpdateEmployeeRequest {

    private String FullName;
    private String phoneNumber;
    private String mailAddress;
    private String address;
}
