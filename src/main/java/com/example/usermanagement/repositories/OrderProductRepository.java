package com.example.usermanagement.repositories;

import com.example.usermanagement.models.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderProductRepository extends JpaRepository<OrderProduct, Long> {

    @Query("SELECT p FROM orderProduct p JOIN p.order u WHERE p.id = u.id")
    List<OrderProduct> findOrders();
}
