package com.rohit.org;

import com.rohit.org.model.Basket;
import com.rohit.org.model.BasketItem;
import com.rohit.org.model.Category;
import com.rohit.org.model.Product;
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
        Product product = new Product("Book", Category.BOOK, true,BigDecimal.valueOf(10));
        BasketItem basketItem = new BasketItem(product,1, BigDecimal.valueOf(50), BigDecimal.valueOf(10));
        basket.addBasketItem(basketItem);

        Assertions.assertEquals(1,basket.size());
    }

    @Test
    public void shouldBeAbleToAddMultipleBasketItemWithUnitQuantity(){
        Basket basket=new Basket();

        Product product1 = new Product("Book", Category.BOOK, true, BigDecimal.valueOf(10));
        BasketItem basketItem1 = new BasketItem(product1,1, BigDecimal.valueOf(50), BigDecimal.valueOf(10));
        basket.addBasketItem(basketItem1);

        Product product2 = new Product("Chocolate", Category.FOOD,true ,BigDecimal.valueOf(10));
        BasketItem basketItem2 = new BasketItem(product2,1, BigDecimal.valueOf(30),BigDecimal.valueOf(10) );
        basket.addBasketItem(basketItem2);


        Assertions.assertEquals(2,basket.size());
    }
}
