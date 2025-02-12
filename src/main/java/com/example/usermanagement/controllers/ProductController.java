package com.example.usermanagement.controllers;

import com.example.usermanagement.models.Product;
import com.example.usermanagement.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing products.
 */
@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    /**
     * Constructs a ProductController with the specified ProductService.
     *
     * @param productService the product service
     */
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * Retrieves all products.
     *
     * @return a list of all products
     */
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    /**
     * Retrieves a product by its ID.
     *
     * @param id the ID of the product
     * @return the product with the specified ID, or null if not found
     */
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    /**
     * Adds a new product.
     *
     * @param product the product to add
     * @return the added product
     */
    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    /**
     * Updates an existing product.
     *
     * @param id the ID of the product to update
     * @param product the updated product details
     * @return the updated product, or null if not found
     */
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    /**
     * Reduces the stock of a product.
     *
     * @param id the ID of the product
     * @param quantity the quantity to reduce
     * @return the updated product with reduced stock, or null if not found or insufficient stock
     */
    @PutMapping("/reduceStock/{id}/{quantity}")
    public Product reduceStock(@PathVariable Long id, @PathVariable int quantity) {
        return productService.reduceStock(id, quantity);
    }

    /**
     * Removes a product by its ID.
     *
     * @param product the product to remove
     */
    @DeleteMapping("/removeProduct")
    public void removeProduct(@RequestBody Product product) {
        productService.deleteProduct(product.getId());
    }
}