package com.example.springProjectTobeto.services.dtos.responses.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetOrderResponse {
    private String name;
    private double unitPrice;
    private int quantity;
    private int isActive;
    private int rank;
}
