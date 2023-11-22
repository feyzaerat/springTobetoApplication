package com.example.springProjectTobeto.dtos.responses.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetOrderListResponse {

    private String name;
    private double unitPrice;
    private int quantity;
    private int isActive;
    private int rank;
}
