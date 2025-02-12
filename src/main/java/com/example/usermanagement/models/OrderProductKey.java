package com.example.usermanagement.models;


import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class OrderProductKey implements Serializable {
    private Long orderId;
    private Long productId;

    public OrderProductKey(Long orderId, Long productId) {
        this.orderId = orderId;
        this.productId = productId;
    }

    public OrderProductKey() {
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
