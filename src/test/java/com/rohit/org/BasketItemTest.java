package com.rohit.org;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class BasketItemTest {

    @Test
    public void shouldBeAbleToCreateBasketItemWithTaxPrice(){
        Product product=new Product("Book",Category.BOOK,true ,BigDecimal.valueOf(10));
        BasketItem basketItem = new BasketItem(product,1, BigDecimal.valueOf(50),BigDecimal.valueOf(12));

        Assertions.assertEquals(1,basketItem.getQuantity());
        Assertions.assertEquals(BigDecimal.valueOf(50),basketItem.getPrice());
        Assertions.assertEquals(product,basketItem.getProduct());
        Assertions.assertEquals(BigDecimal.valueOf(12),basketItem.getTaxPrice());
    }
}
