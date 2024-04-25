package com.cdy.ecommerce.ecommerce.admin.v1.account.controller;

import lombok.*;



public class AccountDTO {
    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Request{
        private String userId;
        private int amount;
    }
    @Getter
    @Builder
    public static class Response{
        private int balance;
        public Response(int balance){
            this.balance = balance;
        }
    }
}
