package com.rohit.org;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class ProductServiceTest {

    @Test
    public void shouldBeAbleToCreateProductService(){
        ProductService productService = new ProductService();

        Assertions.assertNotNull(productService);
    }

    @Test
    public void shouldBeAbleToCreateProduct(){
        ProductService productService=new ProductService();

        Product product= productService.createProduct("book",false, BigDecimal.valueOf(50));
        Product expected = new Product("book", Category.BOOK, false, BigDecimal.valueOf(50));

        Assertions.assertEquals(expected,product);
    }
}
