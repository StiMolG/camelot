package com.camelot.application.usecase.product;

import com.camelot.domain.model.Product;
import com.camelot.domain.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateProductUseCase {

    private final ProductRepository productRepository;
    private static final Logger log = LoggerFactory.getLogger(CreateProductUseCase.class);


    public CreateProductUseCase(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Business logic for creating a product would go here
    public Product execute(Product product){
        log.info("CreateProductUseCase.start name={}", product.getName());
        Product saved = productRepository.save(product);
        log.info("CreateProductUseCase.success id={}", saved.getId().value());
        return saved;
    }
}
