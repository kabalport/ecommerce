package com.cdy.ecommerce.ecommerce.api.point.dto;

import lombok.*;


public class PointDTO {
    @Getter
    public static class Request {
        private String userId;
        private Long amount;
    }
    @Getter
    @Builder
    public static class Response {
        private long point;
        public Response(long point) {
            this.point = point;
        }
    }
}