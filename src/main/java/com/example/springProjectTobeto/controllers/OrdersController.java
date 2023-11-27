package com.example.springProjectTobeto.controllers;

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
    private final OrderRepository orderRepository;

    public OrdersController(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    @GetMapping
    public List<Order>getAll(){
        return orderRepository.findAll();
    }

    @GetMapping("{id}")
    public GetOrderResponse getById(@PathVariable int id){
        Order order = orderRepository.findById(id).orElseThrow();
        GetOrderResponse dto = new GetOrderResponse();

        dto.setName(order.getName());
        dto.setQuantity(order.getQuantity());
        dto.setUnitPrice(order.getUnitPrice());

        return dto;
    }
    @PostMapping
    public void add(@RequestBody AddOrderRequest orderForAddDto){

        Order order = new Order();

        order.setName(orderForAddDto.getName());
        order.setUnitPrice(orderForAddDto.getUnitPrice());
        order.setQuantity(orderForAddDto.getQuantity());
        order.setIsActive(orderForAddDto.getIsActive());
        order.setRank(orderForAddDto.getRank());

        orderRepository.save(order);
    }
    @PutMapping("{id}")
    public void updateOrder(@PathVariable int id, @RequestBody UpdateOrderRequest orderForUpdateDto){
        Order updateOrder = orderRepository.findById(id)
                .orElseThrow(()->new RuntimeException("There is no order"));

        updateOrder.setName(orderForUpdateDto.getName());
        updateOrder.setQuantity(orderForUpdateDto.getQuantity());
        updateOrder.setUnitPrice(orderForUpdateDto.getUnitPrice());



        orderRepository.save(updateOrder);
    }

    @DeleteMapping("{id}")
    public void deleteOrder(@PathVariable int id){
        Order deleteOrder = orderRepository.findById(id)
                .orElseThrow(()->new RuntimeException("There is no order"));
        orderRepository.delete(deleteOrder);
    }

}
