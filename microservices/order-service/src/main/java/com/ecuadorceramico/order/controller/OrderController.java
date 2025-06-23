package com.ecuadorceramico.order.controller;

import com.ecuadorceramico.order.dto.OrderDTO;
import com.ecuadorceramico.order.entity.Order;
import com.ecuadorceramico.order.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody @Valid OrderDTO dto, Principal principal) {
        String username = principal.getName();
        return ResponseEntity.ok(orderService.createOrder(dto, username));
    }

    @GetMapping("/my")
    public ResponseEntity<List<Order>> getMyOrders(Principal principal) {
        String username = principal.getName();
        return ResponseEntity.ok(orderService.getOrdersByUser(username));
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.getOrderById(id));
    }
}
