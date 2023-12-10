package com.example.springProjectTobeto.services.abstracts;

import com.example.springProjectTobeto.entities.Order;
import com.example.springProjectTobeto.services.dtos.requests.order.AddOrderRequest;
import com.example.springProjectTobeto.services.dtos.requests.order.UpdateOrderRequest;
import com.example.springProjectTobeto.services.dtos.responses.order.GetOrderListResponse;
import com.example.springProjectTobeto.services.dtos.responses.order.GetOrderResponse;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface OrderService {

    List<Order> getAll();
    GetOrderResponse getById(int id);
    void addOrder(AddOrderRequest addOrderRequest);
    void updateOrder(@PathVariable int id, UpdateOrderRequest updateOrderRequest);
    void deleteOrder(int id);

    List<GetOrderListResponse> getByQuantity(int quantity);
}
