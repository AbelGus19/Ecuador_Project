package com.ecuador.rbac.repository;

import com.ecuador.rbac.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    
    // Para buscar un usuario por su nombre
    Optional<User> findByUsername(String username);
}
