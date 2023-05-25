package com.rohit.org;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasketTest {

    @Test
    public void shouldBeAbleToCreateABasket(){
        Basket basket = new Basket();

        Assertions.assertNotNull(basket);
    }
}
