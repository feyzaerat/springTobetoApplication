package com.example.springProjectTobeto.services.dtos.requests.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCustomerRequest {
    private String name;
    private String phone;
    private String mailAddress;
    private String address;
    private int isActive;
    private int rank;
}
