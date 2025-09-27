package com.camelot.application.usecase.product;

import com.camelot.domain.model.Product;
import com.camelot.domain.repository.ProductRepository;

import java.util.List;

public class GetAllProductsUseCase {
    private final ProductRepository productRepository;

    public GetAllProductsUseCase(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> execute() {
        return productRepository.findAll();
    }
}
