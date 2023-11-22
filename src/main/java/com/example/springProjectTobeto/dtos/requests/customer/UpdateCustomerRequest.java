package com.example.springProjectTobeto.dtos.requests.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCustomerRequest {
    private String name;
    private String phone;
    private String mailAddress;
    private String address;
}
