package com.camelot.infrastructure.controller;

import com.camelot.application.usecase.product.DeleteProductUseCase;
import com.camelot.application.usecase.product.GetAllProductsUseCase;
import com.camelot.domain.model.Product;
import com.camelot.domain.model.ProductId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final GetAllProductsUseCase getAllProducts;
    private final DeleteProductUseCase deleteProduct;
    private static final Logger log = LoggerFactory.getLogger(ProductController.class);

    public ProductController(GetAllProductsUseCase getAllProducts, DeleteProductUseCase deleteProduct) {
        this.getAllProducts = getAllProducts;
        this.deleteProduct = deleteProduct;
    }

    @GetMapping
    public List<Product> getAll() {
        log.info("getAll start");
        List<Product> result = getAllProducts.execute();
        log.info("getAll success count={}", result.size());
        return result;
    }

    @GetMapping("/test")
    public String test() {
        return "Product service is up and running!";
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        log.info("delete start id={}", id);
        deleteProduct.execute(new ProductId(id));
        log.info("delete success id={}", id);
    }
}
