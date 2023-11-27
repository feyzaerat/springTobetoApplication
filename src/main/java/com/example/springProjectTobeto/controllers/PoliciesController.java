package com.example.springProjectTobeto.controllers;

import com.example.springProjectTobeto.services.dtos.requests.policy.AddPolicyRequest;
import com.example.springProjectTobeto.services.dtos.requests.policy.UpdatePolicyRequest;
import com.example.springProjectTobeto.services.dtos.responses.policy.GetPolicyResponse;
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

        dto.setName(policy.getName());
        dto.setIsActive(policy.getIsActive());
        dto.setRank(policy.getRank());

        return dto;
    }

    @PostMapping
    public void add(@RequestBody AddPolicyRequest policyForAddDto){

        Policy policy = new Policy();
        policy.setName(policyForAddDto.getName());
        policy.setIsActive(policy.getIsActive());
        policy.setRank(policyForAddDto.getRank());

        policyRepository.save(policy);
    }

    @PutMapping("{id}")
    public void updatePolicy(@PathVariable int id, @RequestBody UpdatePolicyRequest policyForUpdateDto){
        Policy updatePolicy = policyRepository.findById(id)
                .orElseThrow(()->new RuntimeException("There is no policy"));

        updatePolicy.setName(policyForUpdateDto.getName());


        policyRepository.save(updatePolicy);
    }

    @DeleteMapping("{id}")
    public void deletePolicy(@PathVariable int id){
        Policy deletePolicy = policyRepository.findById(id)
                .orElseThrow(()->new RuntimeException("there is no record with this ID"));
        policyRepository.delete(deletePolicy);
    }
}
