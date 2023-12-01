package com.example.springProjectTobeto.services.concretes;

import com.example.springProjectTobeto.entities.Policy;
import com.example.springProjectTobeto.repositories.PolicyRepository;
import com.example.springProjectTobeto.services.abstracts.PolicyService;
import com.example.springProjectTobeto.services.dtos.requests.bill.AddBillRequest;
import com.example.springProjectTobeto.services.dtos.requests.policy.AddPolicyRequest;
import com.example.springProjectTobeto.services.dtos.requests.policy.UpdatePolicyRequest;
import com.example.springProjectTobeto.services.dtos.responses.policy.GetPolicyResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@AllArgsConstructor
@Service
public class PolicyManager implements PolicyService {
    private final PolicyRepository policyRepository;

    public List<Policy> getAll(){
        return policyRepository.findAll();
    }
    public GetPolicyResponse getById(int id){
        Policy getPolicy = policyRepository.findById(id)
                .orElseThrow(()->new RuntimeException("There is no record"));

        GetPolicyResponse dto = new GetPolicyResponse();
        dto.setName(getPolicy.getName());

        return dto;

    }
    public void addPolicy(AddPolicyRequest addPolicyRequest){
        Policy addPolicy = new Policy();
        addPolicy.setName(addPolicyRequest.getName());

        policyRepository.save(addPolicy);
    }
    public void updatePolicy(@PathVariable int id, UpdatePolicyRequest updatePolicyRequest){
        Policy updatePolicy = policyRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Update Failed !!"));
        updatePolicy.setName(updatePolicyRequest.getName());
        this.policyRepository.save(updatePolicy);
    }

    public void deletePolicy(int id){
        this.policyRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Delete Failed !!"));
        this.policyRepository.deleteById(id);
    }
}

