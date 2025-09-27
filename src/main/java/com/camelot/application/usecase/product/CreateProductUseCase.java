package com.camelot.application.usecase.product;

import com.camelot.domain.model.Product;
import com.camelot.domain.repository.ProductRepository;

public class CreateProductUseCase {

    private final ProductRepository productRepository;


    public CreateProductUseCase(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Business logic for creating a product would go here
    public Product execute(Product product){
        return productRepository.save(product);
    }
}
