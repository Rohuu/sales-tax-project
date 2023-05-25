package com.rohit.org;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class ProductTest {

    @Test
    public void shouldBeAbleToCreateAnProductWithProperties() {
        Product product = new Product("Book", Category.BOOK,true, BigDecimal.valueOf(10));

        Assertions.assertEquals("Book", product.getName());
        Assertions.assertEquals(Category.BOOK, product.getCategory());
        Assertions.assertEquals(true, product.isImported());
        Assertions.assertEquals(BigDecimal.valueOf(10), product.getUnitPrice());
    }

}
