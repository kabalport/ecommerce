package com.cdy.ecommerce.ecommerce.api.v1.account.controller;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

public class AccountDTO {
    @Getter
    public static class Request{
        private String userId;
        private BigDecimal balance;
    }
    @Getter
    @Builder
    public static class Response{
        private BigDecimal balance;
        public Response(BigDecimal balance){
            this.balance = balance;
        }
    }
}
