package com.camelot.infrastructure.persistence.mapper;

import com.camelot.domain.model.Product;
import com.camelot.domain.model.ProductId;
import com.camelot.infrastructure.persistence.entity.ProductEntity;
import lombok.NoArgsConstructor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
@NoArgsConstructor
public class ProductMapper {

    public ProductEntity toEntity(Product product) {
        if (product == null) {
            return null;
        }
        ProductEntity entity = new ProductEntity();
        entity.setId(product.getId().value());
        entity.setName(product.getName());
        entity.setDescription(product.getDescription());
        entity.setPrice(product.getPrice());

        return entity;
    }
    public Product toDomain(ProductEntity entity) {
        if (entity == null) {
            return null;
        }
        return new Product(
                new ProductId(entity.getId()),
                entity.getName(),
                entity.getDescription(),
                entity.getPrice()
        );
    }

}
