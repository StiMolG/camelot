package com.camelot.infrastructure.config;


import com.camelot.application.usecase.product.DeleteProductUseCase;
import com.camelot.application.usecase.product.GetAllProductsUseCase;
import com.camelot.application.usecase.user.RegisterUserUseCase;
import com.camelot.domain.model.Role;
import com.camelot.domain.model.User;
import com.camelot.domain.model.UserId;
import com.camelot.domain.repository.ProductRepository;
import com.camelot.domain.repository.UserRepository;
import com.camelot.infrastructure.persistence.entity.UserEntity;
import com.camelot.infrastructure.persistence.jpa.UserJpaRepository;
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
    public CommandLineRunner init(UserJpaRepository userJpaRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (userJpaRepository.findByUsername("admin").isEmpty()) {
                UserEntity adminEntity = new UserEntity();
                adminEntity.setId(null);
                adminEntity.setUsername("admin");
                adminEntity.setPassword(passwordEncoder.encode("1234")); // 🔐 BCrypt
                adminEntity.setRoles(Set.of(Role.ADMIN, Role.USER));
                userJpaRepository.save(adminEntity); // ✅ guarda de verdad en la BD
                System.out.println("✅ Usuario admin creado en BD: admin / 1234");
            }
        };
    }


}
