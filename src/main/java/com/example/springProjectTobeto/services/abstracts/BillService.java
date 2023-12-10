package com.example.springProjectTobeto.services.abstracts;

import com.example.springProjectTobeto.entities.Bill;
import com.example.springProjectTobeto.services.dtos.requests.bill.AddBillRequest;
import com.example.springProjectTobeto.services.dtos.requests.bill.UpdateBillRequest;
import com.example.springProjectTobeto.services.dtos.responses.bill.GetBillListResponse;
import com.example.springProjectTobeto.services.dtos.responses.bill.GetBillResponse;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface BillService {
    List<Bill> getAll();

    GetBillResponse getById(int id);

    void addBill(AddBillRequest addBillRequest);

    void updateBill(@PathVariable int id, UpdateBillRequest updateBillRequest) throws RuntimeException;

    void deleteBill(int id);


    List<GetBillListResponse> getByName(String name);
}
