package com.example.springProjectTobeto.controllers;

import com.example.springProjectTobeto.dtos.responses.policy.GetPolicyResponse;
import com.example.springProjectTobeto.entities.Policy;
import com.example.springProjectTobeto.repositories.PolicyRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/policies")
public class PoliciesController {
    private final PolicyRepository policyRepository;

    public PoliciesController(PolicyRepository policyRepository){
        this.policyRepository = policyRepository;
    }

    @GetMapping
    public List<Policy> getAll(){
        return policyRepository.findAll();
    }

    @GetMapping("{id}")
    public GetPolicyResponse getById(@PathVariable int id){
        Policy policy = policyRepository.findById(id).orElseThrow();

        GetPolicyResponse dto = new GetPolicyResponse();
        return dto;
    }

    @PostMapping
    public void add(@RequestBody Policy policy){
        policyRepository.save(policy);
    }

    @PutMapping("{id}")
    public void updatePolicy(@PathVariable int id, @RequestBody Policy policy){
        Policy updatePolicy = policyRepository.findById(id)
                .orElseThrow(()->new RuntimeException("There is no policy"));
        updatePolicy.setId(policy.getId());
        updatePolicy.setName(policy.getName());
        updatePolicy.setIsActive(policy.getIsActive());


        policyRepository.save(updatePolicy);
    }

    @DeleteMapping("{id}")
    public void deletePolicy(@PathVariable int id){
        Policy deletePolicy = policyRepository.findById(id)
                .orElseThrow(()->new RuntimeException("there is no record with this ID"));
        policyRepository.delete(deletePolicy);
    }
}
