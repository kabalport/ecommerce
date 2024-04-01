package com.cdy.ecommerce.eCommerce.api.point.dto;

import lombok.*;

public class PointDTO {
    @Getter
    @AllArgsConstructor
    public static class Request {
        private long amount;
    }

    @Builder
    @Getter
    public static class Response {
        private long id;
        private long point;

        public Response(long id, long point) {
            this.id = id;
            this.point = point;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public long getPoint() {
            return point;
        }

        public void setPoint(long point) {
            this.point = point;
        }
    }
}
