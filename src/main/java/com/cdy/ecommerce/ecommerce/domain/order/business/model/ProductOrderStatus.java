package com.cdy.ecommerce.ecommerce.domain.order.business.model;

public enum ProductOrderStatus {
    PENDING, // 대기 중
    CONFIRMED, // 확인됨
    SHIPPED, // 배송됨
    DELIVERED, // 배달됨
    CANCELLED // 취소됨
}
