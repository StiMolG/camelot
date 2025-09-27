package com.camelot.application.usecase.product;

import com.camelot.domain.model.ProductId;
import com.camelot.domain.repository.ProductRepository;

public class DeleteProductUseCase {

    private final ProductRepository productRepository;

    public DeleteProductUseCase(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void execute(ProductId productId) {
        productRepository.delete(productId);
    }
}
