package com.camelot.domain.repository;

import com.camelot.domain.model.Product;
import com.camelot.domain.model.ProductId;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    Optional<Product> findById(ProductId id);
    List<Product> findAll();
    Product save(Product product);
    void delete(ProductId id);
}
