package com.example.usermanagement.services;

import com.example.usermanagement.models.Notification;
import com.example.usermanagement.models.NotificationType;
import com.example.usermanagement.models.Product;
import com.example.usermanagement.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * Service class for managing products.
 */
@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final NotificationService ns;

    /**
     * Constructs a ProductService with the specified ProductRepository.
     *
     * @param productRepository the product repository
     */
    @Autowired
    public ProductService(ProductRepository productRepository, NotificationService ns) {
        this.productRepository = productRepository;
        this.ns = ns;
    }

    /**
     * Retrieves all products.
     *
     * @return a list of all products
     */
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    /**
     * Retrieves a product by its ID.
     *
     * @param id the ID of the product
     * @return the product with the specified ID, or null if not found
     */
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    /**
     * Creates a new product.
     *
     * @param product the product to create
     * @return the created product
     */
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    /**
     * Updates an existing product.
     *
     * @param id the ID of the product to update
     * @param updatedProduct the updated product details
     * @return the updated product, or null if not found
     */
    public Product updateProduct(Long id, Product updatedProduct) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setName(updatedProduct.getName());
            product.setPrice(updatedProduct.getPrice());
            product.setStock(updatedProduct.getStock());
            return productRepository.save(product);
        }
        return null;
    }

    /**
     * Deletes a product by its ID.
     *
     * @param id the ID of the product to delete
     */
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    /**
     * Reduces the stock of a product.
     *
     * @param id the ID of the product
     * @param quantity the quantity to reduce
     * @return the updated product with reduced stock, or null if not found or insufficient stock
     */
    public Notification reduceStock(Long id, int quantity) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            int newStockQuantity = product.getStock() - quantity;
            if (newStockQuantity >= 0) {
                product.setStock(newStockQuantity);
                return null;
            }
            else {
                return ns.saveNotification(new Notification("Not enough " + product.getName(), NotificationType.LOW_INVENTORY));

            }

        }
        return null;
    }
}