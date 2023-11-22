package com.example.springProjectTobeto.controllers;
import com.example.springProjectTobeto.dtos.responses.bill.GetBillResponse;
import com.example.springProjectTobeto.entities.Bill;
import com.example.springProjectTobeto.repositories.BillRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/bills")
public class BillsController {

    private final BillRepository billRepository;

    public BillsController(BillRepository billRepository){
        this.billRepository = billRepository;
    }

    @GetMapping
    public List<Bill> getAll(){
        return billRepository.findAll();
    }

    @GetMapping("{id}")
    public GetBillResponse getById(@PathVariable int id){
        Bill bill = billRepository.findById(id).orElseThrow();

        GetBillResponse dto = new GetBillResponse();
        return dto;
    }

    @PostMapping
    public void add(@RequestBody Bill bill){
        billRepository.save(bill);
    }

    @PutMapping("{id}")
    public void updateBill(@PathVariable int id, @RequestBody Bill bill){
        Bill updateBill = billRepository.findById(bill.getId())
                .orElseThrow(() ->new RuntimeException("There is no record " ));
        updateBill.setId(bill.getId());
        updateBill.setName(bill.getName());
        updateBill.setAmount(bill.getAmount());
        updateBill.setType(bill.getType());
        updateBill.setRank(bill.getRank());
        updateBill.setOrder(bill.getOrder());

        billRepository.save(updateBill);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        Bill deleteBill = billRepository.findById(id)
                .orElseThrow(()->new RuntimeException("There is no bill id"));
        billRepository.delete(deleteBill);
    }

}
