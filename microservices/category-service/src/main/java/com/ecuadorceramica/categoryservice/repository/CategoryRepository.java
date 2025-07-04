package com.ecuadorceramica.categoryservice.repository;

import com.ecuadorceramica.categoryservice.model.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<Category, String> {
}
