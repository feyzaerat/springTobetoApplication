package com.example.springProjectTobeto.controllers;

import com.example.springProjectTobeto.services.abstracts.OrderService;
import com.example.springProjectTobeto.services.dtos.requests.order.AddOrderRequest;
import com.example.springProjectTobeto.services.dtos.requests.order.UpdateOrderRequest;
import com.example.springProjectTobeto.services.dtos.responses.order.GetOrderResponse;
import com.example.springProjectTobeto.entities.Order;
import com.example.springProjectTobeto.repositories.OrderRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/orders")
public class OrdersController {
    private final OrderService orderService;

    public OrdersController(OrderService orderService){
        this.orderService = orderService;
    }

    @GetMapping
    public List<Order>getOrderList(){
        return orderService.getAll();
    }

    @GetMapping("{id}")
    public GetOrderResponse getById(@PathVariable int id){
        return this.orderService.getById(id);
    }
    @PostMapping
    public void add(@RequestBody AddOrderRequest addOrderRequest){
        this.orderService.addOrder(addOrderRequest);
    }
    @PutMapping("{id}")
    public void updateOrder(@PathVariable int id, @RequestBody UpdateOrderRequest updateOrderRequest){
       this.orderService.updateOrder(id,updateOrderRequest);
    }

    @DeleteMapping("{id}")
    public void deleteOrder(@PathVariable int id){
        this.orderService.deleteOrder(id);
    }

}
