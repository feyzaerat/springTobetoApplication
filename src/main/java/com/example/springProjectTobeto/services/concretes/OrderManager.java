package com.example.springProjectTobeto.services.concretes;

import com.example.springProjectTobeto.entities.Order;
import com.example.springProjectTobeto.repositories.OrderRepository;
import com.example.springProjectTobeto.services.abstracts.OrderService;
import com.example.springProjectTobeto.services.dtos.requests.order.AddOrderRequest;
import com.example.springProjectTobeto.services.dtos.requests.order.UpdateOrderRequest;
import com.example.springProjectTobeto.services.dtos.responses.order.GetOrderResponse;
import lombok.AllArgsConstructor;
import org.aspectj.bridge.IMessage;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@AllArgsConstructor
@Service
public class OrderManager implements OrderService {
    private final OrderRepository orderRepository;

    @Override
    public List<Order> getAll(){
        return this.orderRepository.findAll();
    }
    public GetOrderResponse getById(int id){
        Order order = orderRepository.findById(id).orElseThrow();

        GetOrderResponse dto = new GetOrderResponse();
        dto.setName(order.getName());
        dto.setQuantity(order.getQuantity());
        dto.setUnitPrice(order.getUnitPrice());

        return dto;
    }
    @Override
    public void addOrder(AddOrderRequest addOrderRequest){
        boolean results = orderRepository.existsByName(addOrderRequest.getName().trim());

        if(results){
            throw new RuntimeException("Order Name can not be empty !!");
        }
        Order order = new Order();
        order.setName(addOrderRequest.getName());
        order.setQuantity(addOrderRequest.getQuantity());
        order.setUnitPrice(addOrderRequest.getUnitPrice());

        orderRepository.save(order);
    }

    @Override
    public void updateOrder(@PathVariable int id, UpdateOrderRequest updateOrderRequest) throws RuntimeException{
        Order updateOrder = orderRepository.findById(id)
                .orElseThrow(()->
                        new RuntimeException("There is no Any Order with this ID"));
        updateOrder.setName(updateOrderRequest.getName());
        updateOrder.setUnitPrice(updateOrderRequest.getUnitPrice());
        updateOrder.setQuantity(updateOrderRequest.getQuantity());
        this.orderRepository.save(updateOrder);
    }
    @Override
    public void deleteOrder(int id) throws RuntimeException{
        this.orderRepository.findById(id)
                .orElseThrow(()->
                        new RuntimeException("There is no Any Order with this ID"));
        this.orderRepository.deleteById(id);
    }

}
