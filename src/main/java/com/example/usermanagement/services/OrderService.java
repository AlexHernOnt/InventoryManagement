package com.example.usermanagement.services;

import com.example.usermanagement.models.Order;
import com.example.usermanagement.models.User;
import com.example.usermanagement.repositories.OrderProductRepository;
import com.example.usermanagement.repositories.OrderRepository;
import com.example.usermanagement.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class for managing order operations.
 */
@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderProductRepository orderProductRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, OrderProductRepository orderProductRepository){
        this.orderRepository = orderRepository;
        this.orderProductRepository = orderProductRepository;
    }

    public List<Order> getAllOrders(){ return null; }

    public Order getOrderById(Long id) { return null; }

    public Order createOrder(Order order){ return null; }

    public Order changeStatus(Long id, String status){ return null; }
}
