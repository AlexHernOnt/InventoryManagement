package com.example.usermanagement.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderProduct> orderproducts = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private State state = State.NO_COMPLETED;

    public Order() {
    }

    public long getId() {
        return id;
    }

    public List<OrderProduct> getOrderproducts() {
        return orderproducts;
    }

    public void setOrderproducts(List<OrderProduct> orderproducts) {
        this.orderproducts = orderproducts;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
