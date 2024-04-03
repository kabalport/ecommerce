package com.cdy.ecommerce.eCommerce.api.point.dto;

import lombok.*;

public class PointDTO {
    @Getter
    public static class Request {
        private String userId;
        private long amount;
    }

    @Builder
    @Getter
    public static class Response {
        private long point;

        public Response(long point) {
            this.point = point;
        }
    }
}
