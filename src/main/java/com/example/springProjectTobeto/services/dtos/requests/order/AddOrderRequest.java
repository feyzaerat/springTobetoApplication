package com.example.springProjectTobeto.services.dtos.requests.order;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Negative;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddOrderRequest {

    @NotBlank(message = "Order name can not be empty !!!")
    private String name;

    @Min(value = 0,message = "unit price can not be smaller than 0 !!")
    @Negative(message = "unit price can not be smaller than 0 !!")
    private double unitPrice;

    @Min(value = 0,message = "quantity can not be smaller than 0 !!")
    @Negative(message = "quantity can not be smaller than 0 !!")
    private int quantity;

    private int isActive;
    private int rank;
}
