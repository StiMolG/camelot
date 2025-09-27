package com.camelot.infrastructure.controller;

import com.camelot.application.usecase.product.DeleteProductUseCase;
import com.camelot.application.usecase.product.GetAllProductsUseCase;
import com.camelot.domain.model.Product;
import com.camelot.domain.model.ProductId;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final GetAllProductsUseCase getAllProducts;
    private final DeleteProductUseCase deleteProduct;

    public ProductController(GetAllProductsUseCase getAllProducts, DeleteProductUseCase deleteProduct) {
        this.getAllProducts = getAllProducts;
        this.deleteProduct = deleteProduct;
    }

    @GetMapping
    public List<Product> getAll() {
        return getAllProducts.execute();
    }

    @GetMapping("/test")
    public String test() {
        return "Product service is up and running!";
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        deleteProduct.execute(new ProductId(id));
    }
}
