package com.camelot.application.usecase.product;

import com.camelot.domain.model.ProductId;
import com.camelot.domain.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeleteProductUseCase {

    private final ProductRepository productRepository;
    private static final Logger log = LoggerFactory.getLogger(DeleteProductUseCase.class);

    public DeleteProductUseCase(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void execute(ProductId productId) {
        log.info("DeleteProductUseCase.start id={}", productId.value());
        productRepository.delete(productId);
        log.info("DeleteProductUseCase.success id={}", productId.value());
    }
}
