package com.cdy.ecommerce.usecase.stub;

import com.cdy.ecommerce.ecommerce.api.v1.product.controller.ProductDTO;


public class ProductSteps {
    public static ProductDTO.Request addProductRequest() {
        final String userId = "user0";
        final String name = "상품명";
        final int price = 1000;
        final int stock = 100;
        return new ProductDTO.Request(userId, name, price, stock);
    }


}
