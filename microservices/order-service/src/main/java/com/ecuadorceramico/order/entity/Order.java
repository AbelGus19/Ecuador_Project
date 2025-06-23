package com.ecuadorceramico.order.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El productId es obligatorio")
    private Long productId;

    @NotNull(message = "La cantidad es obligatoria")
    @Min(value = 1, message = "La cantidad debe ser mayor a 0")
    private Integer quantity;

    @NotNull(message = "El totalPrice es obligatorio")
    @Min(value = 1, message = "El totalPrice debe ser mayor a 0")
    private Double totalPrice;

    @NotNull
    private String createdBy; // Extraído del JWT
}
