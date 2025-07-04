package com.ecuadorceramica.categoryservice.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "categories")
@Data
public class Category {
    @Id
    private String id;
    private String name;
    private String description;
    private LocalDateTime createdAt = LocalDateTime.now();
}
