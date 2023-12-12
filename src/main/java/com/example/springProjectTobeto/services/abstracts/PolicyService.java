package com.example.springProjectTobeto.services.abstracts;

import com.example.springProjectTobeto.entities.Policy;
import com.example.springProjectTobeto.services.dtos.requests.policy.AddPolicyRequest;
import com.example.springProjectTobeto.services.dtos.requests.policy.UpdatePolicyRequest;
import com.example.springProjectTobeto.services.dtos.responses.policy.GetPolicyListResponse;
import com.example.springProjectTobeto.services.dtos.responses.policy.GetPolicyResponse;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface PolicyService {
    List<Policy> getAll();
    GetPolicyResponse getById(int id);
    void addPolicy(AddPolicyRequest addPolicyRequest);
    void updatePolicy(@PathVariable int id, UpdatePolicyRequest updatePolicyRequest);
    void deletePolicy(int id);
    List<GetPolicyListResponse>getByName(String name);

    List<GetPolicyListResponse> searchAsLike(String name);
}
