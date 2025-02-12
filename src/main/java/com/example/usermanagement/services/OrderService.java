package com.example.usermanagement.services;

import com.example.usermanagement.models.Order;
import com.example.usermanagement.models.OrderProduct;
import com.example.usermanagement.models.Product;
import com.example.usermanagement.models.OrderProduct;
import com.example.usermanagement.models.State;
import com.example.usermanagement.repositories.OrderProductRepository;
import com.example.usermanagement.repositories.OrderRepository;
import com.example.usermanagement.repositories.ProductRepository;
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

    public Order createOrder(Order order){
        Order savedOrder = this.orderRepository.save(order);

        for (OrderProduct orderProduct : order.getOrderproducts()){
            Optional<Product> product = productRepository.findById(orderProduct.getProduct().getId());

            if(product == null){
                throw new RuntimeException("Error");
            }

            orderProduct.setOrder(savedOrder);
            orderProduct.setProduct(product.get());

            orderProductRepository.save(orderProduct);

        }
        return savedOrder; }

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

