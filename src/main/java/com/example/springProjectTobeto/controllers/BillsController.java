package com.example.springProjectTobeto.controllers;

import com.example.springProjectTobeto.entities.Bill;
import com.example.springProjectTobeto.services.abstracts.BillService;
import com.example.springProjectTobeto.services.dtos.requests.bill.AddBillRequest;
import com.example.springProjectTobeto.services.dtos.requests.bill.UpdateBillRequest;
import com.example.springProjectTobeto.services.dtos.responses.bill.GetBillListResponse;
import com.example.springProjectTobeto.services.dtos.responses.bill.GetBillResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/bills")
public class BillsController {

    private final BillService billService;

    public BillsController(BillService billService) {
        this.billService = billService;
    }

    @GetMapping
    public List<Bill> getBillList() {
        return billService.getAll();
    }

    @GetMapping("{id}")
    public GetBillResponse getById(@PathVariable int id) {
        return this.billService.getById(id);
    }

    @PostMapping
    public void addBill(@RequestBody @Valid AddBillRequest addBillRequest) {
        this.billService.addBill(addBillRequest);
    }

    @PutMapping("{id}")
    public void updateBill(@PathVariable int id, @RequestBody UpdateBillRequest updateBillRequest) {
        this.billService.updateBill(id, updateBillRequest);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        this.billService.deleteBill(id);
    }

    @GetMapping("getByName")
    public List<GetBillListResponse> getByName(@RequestParam String name) {
        return this.billService.getByName(name);

    }

    @GetMapping("searchAsLike")
    public List<GetBillListResponse> searchAsLike(@RequestParam String name){
        return this.billService.searchAsLike(name);
    }


}
