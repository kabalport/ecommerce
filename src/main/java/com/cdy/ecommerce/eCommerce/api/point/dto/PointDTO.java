package com.cdy.ecommerce.eCommerce.api.point.dto;

import lombok.*;

public class PointDTO {
    @Getter
    public static class Request {
        private Long memberId;
        private Long amount;
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
