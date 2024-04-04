package com.cdy.ecommerce.ecommerce.domain.product.business.models;

public class StockException extends RuntimeException{

    public StockException(String message){
        super(message);
    }
}
