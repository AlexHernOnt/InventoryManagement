package com.example.usermanagement.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

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
