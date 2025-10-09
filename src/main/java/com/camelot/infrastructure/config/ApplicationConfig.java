package com.camelot.infrastructure.config;


import com.camelot.application.usecase.product.DeleteProductUseCase;
import com.camelot.application.usecase.product.GetAllProductsUseCase;
import com.camelot.application.usecase.user.RegisterUserUseCase;
import com.camelot.domain.model.Role;
import com.camelot.domain.repository.ProductRepository;
import com.camelot.domain.repository.UserRepository;
import com.camelot.infrastructure.persistence.entity.UserEntity;
import com.camelot.infrastructure.persistence.jpa.UserJpaRepository;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

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
            if (userJpaRepository.findByUsername("stmolinag").isEmpty()) {
                UserEntity adminEntity = new UserEntity();
                adminEntity.setId(null);
                adminEntity.setEmail("stmolinag@gmail.com");
                adminEntity.setUsername("stmolinag");
                adminEntity.setPassword(passwordEncoder.encode("Lancelot1509.")); // 🔐 BCrypt
                adminEntity.setRoles(Set.of(Role.ADMIN, Role.USER));
                userJpaRepository.save(adminEntity); // ✅ guarda de verdad en la BD
            }
        };
    }


    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Camelot API")
                        .description("Documentación de la API de Camelot")
                        .version("v1")
                        .contact(new Contact().name("Equipo Camelot").email("soporte@camelot.local"))
                        .license(new License().name("Apache 2.0"))
                );
    }


}
