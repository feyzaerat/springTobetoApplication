package com.example.springProjectTobeto.controllers;

import com.example.springProjectTobeto.entities.Policy;
import com.example.springProjectTobeto.services.abstracts.PolicyService;
import com.example.springProjectTobeto.services.dtos.requests.policy.AddPolicyRequest;
import com.example.springProjectTobeto.services.dtos.requests.policy.UpdatePolicyRequest;
import com.example.springProjectTobeto.services.dtos.responses.policy.GetPolicyListResponse;
import com.example.springProjectTobeto.services.dtos.responses.policy.GetPolicyResponse;
import jakarta.validation.Valid;
import org.springframework.data.repository.cdi.Eager;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/policies")
public class PoliciesController {
    private final PolicyService policyService;

    public PoliciesController(PolicyService policyService) {
        this.policyService = policyService;
    }

    @GetMapping
    public List<Policy> getPolicyList() {
        return policyService.getAll();
    }

    @GetMapping("{id}")
    public GetPolicyResponse getById(@PathVariable int id) {
        return this.policyService.getById(id);
    }

    @PostMapping
    public void addPolicy(@RequestBody @Valid AddPolicyRequest addPolicyRequest) {
        this.policyService.addPolicy(addPolicyRequest);
    }

    @PutMapping("{id}")
    public void updatePolicy(@PathVariable int id, @RequestBody UpdatePolicyRequest updatePolicyRequest) {
        this.policyService.updatePolicy(id, updatePolicyRequest);
    }

    @DeleteMapping("{id}")
    public void deletePolicy(@PathVariable int id) {
        this.policyService.deletePolicy(id);
    }

    @GetMapping("getByName")
    public List<GetPolicyListResponse> getByName(@RequestParam String name) {
        return this.policyService.getByName(name);
    }

    @GetMapping("searchAsLike")
    public List<GetPolicyListResponse>searchAsLike(@RequestParam String name){
        return this.policyService.searchAsLike(name);
    }
}
