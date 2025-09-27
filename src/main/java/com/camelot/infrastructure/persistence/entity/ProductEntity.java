package com.camelot.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "products")
@Setter
@Getter
@NoArgsConstructor
public class ProductEntity {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;
    private String description;
    private BigDecimal price;
}
