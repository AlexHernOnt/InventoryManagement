package com.example.usermanagement.models;

import jakarta.persistence.*;


@Entity
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private State state = State.NO_COMPLETED;

    public Order() {
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
