package com.example.springProjectTobeto.services.dtos.requests.policy;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddPolicyRequest {
    @NotBlank(message = "Policy name can not be empty !!!")
    @Length(min=11,max=11,message = "Policy Name has to be 11 digits !!")
    private String name;

}
