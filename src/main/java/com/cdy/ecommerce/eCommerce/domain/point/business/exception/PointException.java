package com.cdy.ecommerce.eCommerce.domain.point.business.exception;

public class PointException extends RuntimeException {

    public PointException() {
        super();
    }

    public PointException(String message) {
        super(message);
    }

    public PointException(String message, Throwable cause) {
        super(message, cause);
    }

    public PointException(Throwable cause) {
        super(cause);
    }
}