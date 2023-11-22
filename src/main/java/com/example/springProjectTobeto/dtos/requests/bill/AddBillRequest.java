package com.example.springProjectTobeto.dtos.requests.bill;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddBillRequest {
    private String name;
    private int type;
    private double amount;
    private int rank;
}
