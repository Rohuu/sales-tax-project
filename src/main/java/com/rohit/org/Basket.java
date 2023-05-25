package com.rohit.org;


import java.util.ArrayList;
import java.util.List;

public class Basket {
    List<BasketItem> basketItems=new ArrayList<>();

    public void addBasketItem(BasketItem basketItem) {
        basketItems.add(basketItem);
    }

    public int size() {
        return basketItems.size();
    }
}
