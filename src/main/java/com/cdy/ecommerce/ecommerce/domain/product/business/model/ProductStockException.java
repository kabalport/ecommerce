package com.cdy.ecommerce.ecommerce.domain.product.business.model;

public class ProductStockException extends RuntimeException{

    public ProductStockException(String message){
        super(message);
    }
}
