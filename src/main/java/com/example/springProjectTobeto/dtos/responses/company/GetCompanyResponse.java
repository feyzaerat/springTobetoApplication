package com.example.springProjectTobeto.dtos.responses.company;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCompanyResponse {
    private String name;
    private String contactName;
    private String contactPhone;
    private String address;
    private int isActive;
    private int rank;
}
