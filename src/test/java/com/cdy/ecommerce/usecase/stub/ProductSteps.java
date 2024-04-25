package com.cdy.ecommerce.usecase.stub;

import com.cdy.ecommerce.ecommerce.domain.product.api.ProductDTO;

import java.math.BigDecimal;


public class ProductSteps {
    public static ProductDTO.Request addProductRequest() {
        final String userId = "user0";
        final String name = "상품명";
        final BigDecimal price = BigDecimal.valueOf(1000);
        final int stock = 100;
        return new ProductDTO.Request(userId, name, price, stock);
    }


}
