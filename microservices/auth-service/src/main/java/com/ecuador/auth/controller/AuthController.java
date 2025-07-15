package com.ecuador.auth.controller;

import com.ecuador.auth.service.AuthService;
import com.ecuador.auth.dto.LoginRequest;
import com.ecuador.auth.dto.LoginResponse;
import com.ecuador.auth.entity.User;
import com.ecuador.auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        // 🔧 Limpieza de username
        String cleanUsername = user.getUsername().trim().toLowerCase();
        user.setUsername(cleanUsername);

        if (userRepository.findByUsername(cleanUsername).isPresent()) {
            return ResponseEntity.badRequest().body("Username already exists");
        }

        user.setRole("USER");
        return ResponseEntity.ok(userRepository.save(user));
    }

    @GetMapping("/test")
    public String test() {
        return "Auth service is working!";
    }
    
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        try {
            return ResponseEntity.ok(authService.login(request));
        } catch (Exception e) {
        // Para debugging: imprime el error en consola y devuelve mensaje explícito
            e.printStackTrace();
            return ResponseEntity.status(401).body("Login failed: " + e.getMessage());
        }
    }   

    @GetMapping("/private")
    public ResponseEntity<String> privateEndpoint() {
        return ResponseEntity.ok("You have accessed a protected route!");
    }


}
