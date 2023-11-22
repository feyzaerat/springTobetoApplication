package com.example.springProjectTobeto.controllers;

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
    public Order getById(@PathVariable int id){
        return orderRepository.findById(id).orElseThrow();
    }
    @PostMapping
    public void add(@RequestBody Order order){
        orderRepository.save(order);
    }
    @PutMapping("{id}")
    public void updateOrder(@PathVariable int id, @RequestBody Order order){
        Order updateOrder = orderRepository.findById(id)
                .orElseThrow(()->new RuntimeException("There is no order"));
        updateOrder.setId(order.getId());
        updateOrder.setName(order.getName());
        updateOrder.setQuantity(order.getQuantity());
        updateOrder.setUnitPrice(order.getUnitPrice());
        updateOrder.setIsActive(order.getIsActive());
        updateOrder.setRank(order.getRank());


        orderRepository.save(updateOrder);
    }

    @DeleteMapping("{id}")
    public void deleteOrder(@PathVariable int id){
        Order deleteOrder = orderRepository.findById(id)
                .orElseThrow(()->new RuntimeException("There is no order"));
        orderRepository.delete(deleteOrder);
    }

}