package com.example.usermanagement.controllers;

import com.example.usermanagement.models.Order;
import com.example.usermanagement.models.OrderProduct;
import com.example.usermanagement.services.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller for managing order-related operations.
 */
@RestController
@RequestMapping("/order")

public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) { this.orderService = orderService; }

    @GetMapping
    public List<Order> getAllOrders() {return this.orderService.getAllOrders();}

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Order createOrder(@RequestBody Order order) { return this.orderService.createOrder(order);}

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return this.orderService.getOrderById(id);
    }

    @PatchMapping("/{id}")
    public Order switchStatus(@PathVariable Long id, String status) {
        return this.orderService.changeStatus(id, status);
    }

}

