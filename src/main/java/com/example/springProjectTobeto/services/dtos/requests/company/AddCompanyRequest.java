package com.example.springProjectTobeto.services.dtos.requests.company;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCompanyRequest {
    private String name;
    private String contactName;
    private String contactPhone;
    private String address;

}
