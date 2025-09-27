package com.camelot.infrastructure.persistence.adapter;

import com.camelot.domain.model.Product;
import com.camelot.domain.model.ProductId;
import com.camelot.domain.repository.ProductRepository;
import com.camelot.infrastructure.persistence.entity.ProductEntity;
import com.camelot.infrastructure.persistence.jpa.ProductJpaRepository;
import com.camelot.infrastructure.persistence.mapper.ProductMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductRepositoryAdapter implements ProductRepository {

    private final ProductJpaRepository productJpaRepository;
    private final ProductMapper productMapper;


    public ProductRepositoryAdapter(ProductJpaRepository productJpaRepository, ProductMapper productMapper) {
        this.productJpaRepository = productJpaRepository;
        this.productMapper = productMapper;
    }

    // Implement repository methods here
    @Override
    public Optional<Product> findById(ProductId id) {
       return productJpaRepository.findById(id.value())
               .map(productMapper::toDomain);
    }

    @Override
    public Product save(Product product){
        ProductEntity entity = productMapper.toEntity(product);
        ProductEntity savedEntity = productJpaRepository.save(entity);
        return productMapper.toDomain(savedEntity);
    }

    @Override
    public void delete(ProductId id) {
        if (id.value() == null) return;
        productJpaRepository.deleteById(id.value());
    }

    @Override
    public List<Product> findAll() {
        return productJpaRepository.findAll()
                .stream()
                .map(productMapper::toDomain)
                .toList();
    }

}

