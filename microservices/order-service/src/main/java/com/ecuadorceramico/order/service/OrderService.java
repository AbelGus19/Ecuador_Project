package com.ecuadorceramico.order.service;

import com.ecuadorceramico.order.dto.OrderDTO;
import com.ecuadorceramico.order.entity.Order;
import com.ecuadorceramico.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order createOrder(OrderDTO dto, String username) {
        Order order = Order.builder()
                .productId(dto.getProductId())
                .quantity(dto.getQuantity())
                .totalPrice(dto.getTotalPrice())
                .createdBy(username)
                .build();

        return orderRepository.save(order);
    }

    public List<Order> getOrdersByUser(String username) {
        return orderRepository.findByCreatedBy(username);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }
}
