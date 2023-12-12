package com.example.springProjectTobeto.repositories;

import com.example.springProjectTobeto.entities.Order;
import com.example.springProjectTobeto.services.dtos.responses.order.GetOrderListResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findByQuantityEquals(int quantity);

    boolean existsByName(String name);

    @Query("SELECT o FROM Order o Where o.quantity LIKE %:quantity%")
    List<Order> searchAsLike(int quantity);

    @Query(value = "Select * from orders Where quantity LIKE %:quantity%", nativeQuery = true)
    List<Order> searchAsValue(int quantity);

    @Query("SELECT new com.example.springProjectTobeto.services.dtos.responses.order.GetOrderListResponse(o.quantity) " +
            "FROM Order o Where o.quantity LIKE %:quantity%")
    List<GetOrderListResponse> searchAsList(int quantity);

}
