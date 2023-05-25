package com.rohit.org;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class ProductTest {

    @Test
    public void shouldBeAbleToCreateAnProductWithName(){
        Product product = new Product("Book");

        Assertions.assertEquals("Book",product.getName());
    }
}