package com.rohit.org;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class BasketTest {

    @Test
    public void shouldBeAbleToCreateABasket(){
        Basket basket = new Basket();

        Assertions.assertNotNull(basket);
    }

    @Test
    public void shouldBeAbleToAddBasketItem(){
        Basket basket=new Basket();
        Product product = new Product("Book", Category.BOOK);
        BasketItem basketItem = new BasketItem(product,1, BigDecimal.valueOf(50));
        basket.addBasketItem(basketItem);

        Assertions.assertEquals(1,basket.size());
    }
}
