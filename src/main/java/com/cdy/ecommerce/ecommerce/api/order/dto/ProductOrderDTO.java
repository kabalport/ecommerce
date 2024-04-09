package com.cdy.ecommerce.ecommerce.api.order.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class ProductOrderDTO {
    @Getter
    @Setter
    public static class Request {
        private String userId;
        private List<ProductOrderDetail> products;
    }

    @Getter
    @Setter
    public static class ProductOrderDetail {
        private Long productId;
        private int quantity;
    }
}
