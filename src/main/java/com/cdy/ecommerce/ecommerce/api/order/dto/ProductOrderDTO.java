package com.cdy.ecommerce.ecommerce.api.order.dto;

import com.cdy.ecommerce.ecommerce.domain.order.business.ProductOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
// 사용자 식별자와 (상품 ID, 수량) 목록을 입력받아 주문하고 결제를 수행하는 API 를 작성합니다.
public class ProductOrderDTO {
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Request {
        private String userId;
        private List<ProductOrderDetail> products;
    }
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ProductOrderDetail {
        private Long productId;
        private int quantity;
    }
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Response {
        private Long orderId;
        private String userId;
        private List<ProductOrder> products;

        //private String status;
    }
}
