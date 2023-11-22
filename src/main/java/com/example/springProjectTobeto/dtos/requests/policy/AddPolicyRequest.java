package com.example.springProjectTobeto.dtos.requests.policy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddPolicyRequest {
    private String name;
    private int isActive;
    private int rank;
}
