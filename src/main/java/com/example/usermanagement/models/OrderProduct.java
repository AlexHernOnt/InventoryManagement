package com.example.usermanagement.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "Order_product")
public class OrderProduct {

    @EmbeddedId
    private OrderProductKey orderProductKey;

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id", nullable = false)
    @MapsId("orderId")
    @JsonIgnore
    private Order order;


    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false)
    @MapsId("productId")
    private Product product;

    private int quantity;

    public OrderProduct() {
    }

    public OrderProduct(OrderProductKey orderProductKey, Order order, Product product, int quantity) {
        this.orderProductKey = orderProductKey;
        this.order = order;
        this.product = product;
        this.quantity = quantity;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public OrderProductKey getOrderProductKey() {
        return orderProductKey;
    }

    public void setOrderProductKey(OrderProductKey orderProductKey) {
        this.orderProductKey = orderProductKey;
    }
}
