package com.example.usermanagement.models;

import jakarta.persistence.*;

/**
 * Entity class representing a product.
 */
@Entity
@Table(name = "product")
public class Product {

    /**
     * The product ID.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The unique name of the product.
     */
    @Column(nullable = false, unique = true)
    private String name;

    /**
     * The price of the product.
     */
    @Column(nullable = false)
    private double price;

    /**
     * The stock quantity of the product.
     */
    @Column(nullable = false)
    private int stock;

    /**
     * Default constructor.
     */
    public Product() {
    }

    /**
     * Constructs a Product with the specified name, price, and stock.
     *
     * @param name  the name of the product
     * @param price the price of the product
     * @param stock the stock quantity of the product
     */
    public Product(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    /**
     * Returns the ID of the product.
     *
     * @return the ID of the product
     */
    public Long getId() {
        return id;
    }

    /**
     * Returns the name of the product.
     *
     * @return the name of the product
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the product.
     *
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the price of the product.
     *
     * @return the price of the product
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the product.
     *
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Returns the stock quantity of the product.
     *
     * @return the stock quantity of the product
     */
    public int getStock() {
        return stock;
    }

    /**
     * Sets the stock quantity of the product.
     *
     * @param stock the stock quantity to set
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * Returns a string representation of the product.
     *
     * @return a string representation of the product
     */
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }
}