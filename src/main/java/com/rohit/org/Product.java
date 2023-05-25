package com.rohit.org;

import java.math.BigDecimal;

public class Product {
    private final String name;
    private final Category category;
    private boolean isImported;
    private BigDecimal unitPrice;

    public Product(String name, Category category, boolean isImported, BigDecimal unitPrice) {
        this.name = name;
        this.category = category;
        this.isImported = isImported;
        this.unitPrice = unitPrice;
    }


    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public boolean isImported() {
        return true;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }
}
