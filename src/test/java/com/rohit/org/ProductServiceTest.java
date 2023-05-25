package com.rohit.org;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class ProductServiceTest {

    @Test
    public void shouldBeAbleToCreateProductService(){
        CategoryService categoryService = new CategoryService();
        ProductService productService = new ProductService(categoryService);

        Assertions.assertNotNull(productService);
    }

    @Test
    public void shouldBeAbleToCreateProduct(){
        CategoryService categoryService = new CategoryService();
        ProductService productService=new ProductService(categoryService);

        Product product= productService.createProduct("book",false, BigDecimal.valueOf(50));
        Product expected = new Product("book", Category.BOOK, false, BigDecimal.valueOf(50));

        Assertions.assertEquals(expected,product);
    }

    @Test
    public void shouldBeAbleToCreateProductWithCategory(){
        CategoryService categoryService = new CategoryService();
        ProductService productService=new ProductService(categoryService);

        Product product= productService.createProduct("bottle",false, BigDecimal.valueOf(500));
        Product expected = new Product("bottle", Category.OTHERS, false, BigDecimal.valueOf(500));

        Assertions.assertEquals(expected,product);
    }
}
