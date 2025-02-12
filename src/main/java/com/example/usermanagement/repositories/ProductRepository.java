package com.example.usermanagement.repositories;

import com.example.usermanagement.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing Product entities.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}