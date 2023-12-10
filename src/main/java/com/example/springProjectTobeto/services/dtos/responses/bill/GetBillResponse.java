package com.example.springProjectTobeto.services.dtos.responses.bill;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetBillResponse {
    private String name;
    private LocalDate created_at;
    private int type;
    private double amount;
    private int rank;
}
