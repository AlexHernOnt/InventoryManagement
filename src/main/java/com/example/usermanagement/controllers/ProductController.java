package com.example.usermanagement.controllers;

import com.example.usermanagement.models.Product;
import com.example.usermanagement.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

//    @PutMapping("/reduceStock/{Id}")
//    public String reduceStock(@Valid @RequestBody Product product) {
//        stockService.reduceStock(productId, product.getStock());
//    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }


    @PutMapping("/{id}")
    public Product reduceStock(@PathVariable Long id, @RequestBody Product product) {
        return productService.updateProduct(product);
    }

    @DeleteMapping("/removeProduct")
    public void removeProduct(@RequestBody Product product) {
        productService.deleteProduct(product.getId());
    }
}
