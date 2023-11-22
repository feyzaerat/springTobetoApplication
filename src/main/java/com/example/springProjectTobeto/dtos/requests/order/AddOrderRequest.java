package com.example.springProjectTobeto.dtos.requests.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddOrderRequest {

    private String name;
    private double unitPrice;
    private int quantity;
    private int isActive;
    private int rank;
}
