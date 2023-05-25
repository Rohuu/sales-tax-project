package com.rohit.org;

import java.math.BigDecimal;

public class ProductService {

    public Product createProduct(String productName, boolean isImported, BigDecimal unitPrice) {
        return new Product(productName,Category.BOOK,isImported,unitPrice);
    }
}
