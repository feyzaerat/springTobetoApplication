package com.example.springProjectTobeto.controllers;

import com.example.springProjectTobeto.dtos.requests.order.UpdateOrderRequest;
import com.example.springProjectTobeto.dtos.responses.order.GetOrderResponse;
import com.example.springProjectTobeto.entities.Order;
import com.example.springProjectTobeto.repositories.OrderRepository;
import org.aspectj.weaver.ast.Or;
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
    public void add(@RequestBody Order order){
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
