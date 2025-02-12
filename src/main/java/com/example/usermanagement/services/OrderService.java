package com.example.usermanagement.services;

import com.example.usermanagement.models.Order;
import com.example.usermanagement.models.OrderProduct;
import com.example.usermanagement.repositories.OrderProductRepository;
import com.example.usermanagement.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<OrderProduct> getAllOrders(){ return orderProductRepository.findOrders(); }

    public Order getOrderById(Long id) { return null; }

    public Order createOrder(Order order){ return null; }

    public Order changeStatus(Long id, String status){ return null; }
}

