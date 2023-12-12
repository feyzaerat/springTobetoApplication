package com.example.springProjectTobeto.services.dtos.requests.bill;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddBillRequest {
    @NotBlank(message = "You must enter the Bill Name !!")
    @Length(min = 11, max = 11, message = "The Brand Name must be 11 digits !!")
    private String name;
    private int type;
    private double amount;
    private int rank;
}
