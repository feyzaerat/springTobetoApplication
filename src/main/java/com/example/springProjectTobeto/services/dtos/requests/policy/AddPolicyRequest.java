package com.example.springProjectTobeto.services.dtos.requests.policy;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddPolicyRequest {
    @NotBlank(message = "Policy name can not be empty !!!")
    private String name;

}
