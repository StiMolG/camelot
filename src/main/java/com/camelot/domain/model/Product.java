package com.camelot.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Product {
    private ProductId id;
    private String name;
    private String description;
    private BigDecimal price;

    public Product(ProductId id) {
        this.id = id;
    }
}
