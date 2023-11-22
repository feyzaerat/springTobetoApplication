package com.example.springProjectTobeto.dtos.responses.policy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetPolicyResponse {
    private String name;
    private int isActive;
    private int rank;
}
