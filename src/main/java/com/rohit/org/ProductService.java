package com.rohit.org;

import java.math.BigDecimal;

public class ProductService {

    private final CategoryService categoryService;

    public ProductService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public Product createProduct(String productName, boolean isImported, BigDecimal unitPrice) {
        return new Product(productName,categoryService.getCategoryByProductName(productName),isImported,unitPrice);
    }
}
