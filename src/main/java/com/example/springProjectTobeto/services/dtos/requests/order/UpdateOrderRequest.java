package com.example.springProjectTobeto.services.dtos.requests.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UpdateOrderRequest {
    private String name;
    private double unitPrice;
    private int quantity;

}
