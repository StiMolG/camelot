package com.camelot.infrastructure.config;


import com.camelot.application.usecase.product.DeleteProductUseCase;
import com.camelot.application.usecase.product.GetAllProductsUseCase;
import com.camelot.application.usecase.user.RegisterUserUseCase;
import com.camelot.domain.model.Role;
import com.camelot.domain.model.User;
import com.camelot.domain.model.UserId;
import com.camelot.domain.repository.ProductRepository;
import com.camelot.domain.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;
import java.util.UUID;

@Configuration
public class ApplicationConfig {

    @Bean
    public GetAllProductsUseCase getAllProductsUseCase(ProductRepository repo) {
        return new GetAllProductsUseCase(repo);
    }

    @Bean
    public DeleteProductUseCase deleteProductUseCase(ProductRepository repo) {
        return new DeleteProductUseCase(repo);
    }

    @Bean
    public RegisterUserUseCase registerUserUseCase(UserRepository repo) {
        return new RegisterUserUseCase(repo);
    }


    @Bean
    public CommandLineRunner init(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (userRepository.findByUsername("admin").isEmpty()) {
                User admin = new User(
                        new UserId(new UUID(
0L, 1L
                        )), // o UUID si así lo manejas
                        "admin",
                        "admin@mail.com",
                        passwordEncoder.encode("1234"),
                        Set.of(Role.ADMIN) // 👈 directamente inicializado
                );
                System.out.println("✅ Usuario admin creado: admin / 1234");
            }
        };
    }

}
