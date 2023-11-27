package com.example.springProjectTobeto.services.dtos.responses.bill;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetBillResponse {
    private String name;
    private int type;
    private double amount;
    private int rank;
}
