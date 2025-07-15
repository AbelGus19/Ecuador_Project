package com.ecuador.auth.service;

import com.ecuador.auth.dto.LoginRequest;
import com.ecuador.auth.dto.LoginResponse;
import com.ecuador.auth.entity.User;
import com.ecuador.auth.repository.UserRepository;
import com.ecuador.auth.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    public LoginResponse login(LoginRequest request) {
    String username = request.getUsername().trim().toLowerCase();
    System.out.println("Buscando usuario: " + username);

    User user = userRepository.findByUsername(username)
        .orElseThrow(() -> new RuntimeException("User not found"));

    System.out.println("Usuario encontrado: " + user.getUsername());

    if (!user.getPassword().equals(request.getPassword())) {
        System.out.println("Contraseña inválida");
        throw new RuntimeException("Invalid password");
    }

    String token = jwtUtil.generateToken(user.getUsername());
    System.out.println("Token generado: " + token);
    return new LoginResponse(token);
}


}
