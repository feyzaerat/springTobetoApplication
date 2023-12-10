package com.example.springProjectTobeto.services.dtos.requests.order;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddOrderRequest {

    @NotBlank(message = "Order name can not be empty !!!")
    @Length(min = 11, max = 11, message = "Order Name has to be 11 digits !!")
    private String name;

    @Min(value = 0, message = "unit price can not be smaller than 0 !!")
    @Positive(message = "unit price can not be smaller than 0 !!")
    private double unitPrice;

    @Min(value = 0, message = "quantity can not be smaller than 0 !!")
    @Positive(message = "quantity can not be smaller than 0 !!")
    private int quantity;

    private int isActive;
    private int rank;
}
