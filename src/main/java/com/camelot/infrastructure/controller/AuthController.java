package com.camelot.infrastructure.controller;

import com.camelot.infrastructure.security.JwtProvider;
import com.camelot.infrastructure.security.dto.JwtResponse;
import com.camelot.infrastructure.security.dto.LoginRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger log = LoggerFactory.getLogger(AuthController.class);

    public AuthController(AuthenticationManager authManager, JwtProvider jwtProvider) {
        this.authManager = authManager;
        this.jwtProvider = jwtProvider;
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        log.info("login start username={}", request.username());
        Authentication auth = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.username(), request.password())
        );

        // ✅ Ahora sí: usamos el username directamente
        String token = jwtProvider.generateToken(auth.getName());
        log.info("login success username={}", auth.getName());
        return token;
    }

}
