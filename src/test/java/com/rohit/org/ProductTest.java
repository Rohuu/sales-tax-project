package com.rohit.org;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ProductTest {

    @Test
    public void shouldBeAbleToCreateAnProductWithNameAndCategory() {
        Product product = new Product("Book", Category.BOOK);

        Assertions.assertNotNull(product);
        Assertions.assertEquals("Book", product.getName());
        Assertions.assertEquals(Category.BOOK, product.getCategory());
    }
}
