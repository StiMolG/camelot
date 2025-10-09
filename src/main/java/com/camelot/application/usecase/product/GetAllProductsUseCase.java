package com.camelot.application.usecase.product;

import com.camelot.domain.model.Product;
import com.camelot.domain.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class GetAllProductsUseCase {
    private final ProductRepository productRepository;
    private static final Logger log = LoggerFactory.getLogger(GetAllProductsUseCase.class);

    public GetAllProductsUseCase(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> execute() {
        log.info("GetAllProductsUseCase.start");
        List<Product> products = productRepository.findAll();
        log.info("GetAllProductsUseCase.success count={}", products.size());
        return products;
    }
}
