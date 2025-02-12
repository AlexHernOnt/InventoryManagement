package com.example.usermanagement.services;

import com.example.usermanagement.models.Order;
import com.example.usermanagement.models.OrderProduct;
import com.example.usermanagement.models.State;
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
    private ProductService productService;

    @Autowired
    public OrderService(OrderRepository orderRepository, OrderProductRepository orderProductRepository, ProductService productService){
        this.orderRepository = orderRepository;
        this.orderProductRepository = orderProductRepository;
        this.productService = productService;
    }

    public List<Order> getAllOrders(){ return this.orderRepository.findAll(); }

    public Order getOrderById(Long id) { return this.orderRepository.findById(id).orElse(null);}

    public Order createOrder(Order order){ return null; }

    public Order changeStatus(Long id, String status){
        Order order = this.orderRepository.findById(id).orElse(null);
        if(status.equals(State.COMPLETED)) {

            if (order != null) {
                for (OrderProduct orderProduct : order.getOrderproducts()) {
                    this.productService.reduceStock(orderProduct.getProduct().getId(), orderProduct.getQuantity());
                }
            }

        }
        order.setState(State.valueOf(status));
        return order;
    }
}

