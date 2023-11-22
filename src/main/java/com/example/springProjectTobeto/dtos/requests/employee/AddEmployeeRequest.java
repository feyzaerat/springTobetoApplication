package com.example.springProjectTobeto.dtos.requests.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddEmployeeRequest {
    private String fullName;
    private String phoneNumber;
    private String mailAddress;
    private String address;
    private int isActive;
    private int rank;

}
