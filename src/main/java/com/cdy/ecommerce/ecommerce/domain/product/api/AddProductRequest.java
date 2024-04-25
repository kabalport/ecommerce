package com.cdy.ecommerce.ecommerce.domain.product.api;

import java.math.BigDecimal;

public class AddProductRequest {
    private final String name;
    private final BigDecimal price;

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public AddProductRequest(String productName, BigDecimal price) {
        this.name = productName;
        this.price = price;
    }
}
