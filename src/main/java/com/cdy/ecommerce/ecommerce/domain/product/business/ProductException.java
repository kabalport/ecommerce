package com.cdy.ecommerce.ecommerce.domain.product.business;

public class ProductException extends RuntimeException {
    public ProductException(String message) {
        super(message);
    }

    public ProductException(String message, Throwable cause) {
        super(message, cause);
    }
}
