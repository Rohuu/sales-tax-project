package com.rohit.org;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class BasketItemTest {

    @Test
    public void shouldBeAbleToCreateBasketItem(){
        Product product=new Product("Book",Category.BOOK);
        BasketItem basketItem = new BasketItem(product,1, BigDecimal.valueOf(50));

        Assertions.assertEquals(1,basketItem.getQuantity());
        Assertions.assertEquals(BigDecimal.valueOf(50),basketItem.getPrice());
        Assertions.assertEquals(product,basketItem.getProduct());
    }
}
