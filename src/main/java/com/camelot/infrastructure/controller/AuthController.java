package com.camelot.infrastructure.controller;

import com.camelot.infrastructure.security.JwtProvider;
import com.camelot.infrastructure.security.dto.JwtResponse;
import com.camelot.infrastructure.security.dto.LoginRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authManager;
    private final JwtProvider jwtProvider;

    public AuthController(AuthenticationManager authManager, JwtProvider jwtProvider) {
        this.authManager = authManager;
        this.jwtProvider = jwtProvider;
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        Authentication auth = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.username(), request.password())
        );

        // ✅ Ahora sí: usamos el username directamente
        String token = jwtProvider.generateToken(auth.getName());
        return token;
    }

}
