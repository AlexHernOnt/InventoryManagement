package com.example.usermanagement.services;

import com.example.usermanagement.models.Order;
import com.example.usermanagement.models.OrderProduct;
import com.example.usermanagement.models.Product;
import com.example.usermanagement.models.OrderProduct;
import com.example.usermanagement.models.State;
import com.example.usermanagement.repositories.OrderProductRepository;
import com.example.usermanagement.repositories.OrderRepository;
import com.example.usermanagement.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class for managing order operations.
 */
@Service
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderProductRepository orderProductRepository;
    private ProductService productService;
    private final ProductRepository productRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, OrderProductRepository orderProductRepository, ProductService productService, ProductRepository productRepository){
        this.orderRepository = orderRepository;
        this.orderProductRepository = orderProductRepository;
        this.productService = productService;
        this.productRepository = productRepository;
    }

    public List<Order> getAllOrders(){ return this.orderRepository.findAll(); }

    public Order getOrderById(Long id) { return this.orderRepository.findById(id).orElse(null);}

    public Order createOrder(Order order) {
        Order savedOrder = orderRepository.save(order);
        return savedOrder;
    }

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

    public Order createOrderProducts(Long id, List<OrderProduct> orderProducts) {
        Order order = this.orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        for (OrderProduct orderProduct : orderProducts) {
            orderProduct.setOrder(order);

            Product product = productRepository.findById(orderProduct.getProduct().getId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));

            orderProduct.setProduct(product);


            orderProductRepository.save(orderProduct);


            order.getOrderproducts().add(orderProduct);
        }

        return orderRepository.save(order);
    }
}

