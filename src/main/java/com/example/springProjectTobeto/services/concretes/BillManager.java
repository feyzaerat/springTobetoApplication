package com.example.springProjectTobeto.services.concretes;

import com.example.springProjectTobeto.entities.Bill;
import com.example.springProjectTobeto.repositories.BillRepository;
import com.example.springProjectTobeto.services.abstracts.BillService;
import com.example.springProjectTobeto.services.dtos.requests.bill.AddBillRequest;
import com.example.springProjectTobeto.services.dtos.requests.bill.UpdateBillRequest;
import com.example.springProjectTobeto.services.dtos.responses.bill.GetBillListResponse;
import com.example.springProjectTobeto.services.dtos.responses.bill.GetBillResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class BillManager implements BillService {
    private final BillRepository billRepository;

    @Override
    public List<Bill> getAll() {
        return billRepository.findAll();
    }

    @Override
    public GetBillResponse getById(int id) {
        Bill getBill = billRepository.findById(id).orElseThrow();

        GetBillResponse dto = new GetBillResponse();
        dto.setName(getBill.getName());
        dto.setType(getBill.getType());
        dto.setAmount(getBill.getAmount());

        return dto;
    }

    @Override
    public void addBill(AddBillRequest addBillRequest) {

        boolean result = billRepository.existsByName(addBillRequest.getName().trim());

        if (result) {
            throw new RuntimeException("The Bill Name has to be unique !!");
        }
        Bill addBill = new Bill();
        addBill.setName(addBillRequest.getName());
        addBill.setType(addBillRequest.getType());
        addBill.setAmount(addBillRequest.getAmount());

        billRepository.save(addBill);
    }

    @Override
    public void updateBill(@PathVariable int id, UpdateBillRequest updateBillRequest) throws RuntimeException {
        Bill updateBill = billRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Update Failed !!"));
        updateBill.setName(updateBillRequest.getName());
        updateBill.setType(updateBillRequest.getType());
        updateBill.setAmount(updateBillRequest.getAmount());

        this.billRepository.save(updateBill);
    }

    @Override
    public void deleteBill(int id) {
        this.billRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Delete Failed !! There is no ID"));
        this.billRepository.deleteById(id);
    }

    @Override
    public List<GetBillListResponse> getByName(String name) {

        List<Bill> bills = billRepository.findByNameLike("%" + name + "%");
        List<GetBillListResponse> response = new ArrayList<>();

        for (Bill bill : bills) {
            response.add(new GetBillListResponse(bill.getName()));
        }
        return response;
    }

    @Override
    public List<GetBillListResponse> searchAsLike(String name){
        List<Bill> bills = billRepository.searchAsValue(name);
        return billRepository.searchAsList(name);
    }


}
