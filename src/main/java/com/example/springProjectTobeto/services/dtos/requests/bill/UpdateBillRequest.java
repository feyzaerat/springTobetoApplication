package com.example.springProjectTobeto.services.dtos.requests.bill;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBillRequest {

    private String name;
    private double amount;
    private int type;
}
