package com.cdy.ecommerce.ecommerce.api.order.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
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
        private Long quantity;
    }

    @Getter
    @Builder
    public static class Response {
        private Long orderId;
        private String status;
        private List<OrderItem> items;
        private BigDecimal totalAmount;
    }

    @Getter
    @Builder
    public static class OrderItem {
        private Long productId;
        private Long quantity;
        private BigDecimal price;
    }

}
