package com.ecuadorceramico.order.repository;

import com.ecuadorceramico.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByCreatedBy(String createdBy);
}
