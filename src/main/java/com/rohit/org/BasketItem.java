package com.rohit.org;

import java.math.BigDecimal;

public class BasketItem {
    private final Product product;
    private final int quantity;
    private final BigDecimal price;

    public BasketItem(Product product, int quantity, BigDecimal price) {
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Product getProduct() {
        return product;
    }
}
