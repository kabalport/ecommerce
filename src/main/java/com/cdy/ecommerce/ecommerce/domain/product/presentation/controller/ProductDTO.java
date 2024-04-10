package com.cdy.ecommerce.ecommerce.domain.product.presentation.controller;

import lombok.*;

@Data
public class ProductDTO {

  @Data
  @Builder
  @AllArgsConstructor
  @NoArgsConstructor
  public static class Request {

    private String userId;
    private String name;
    private int price;
    private int stock;
  }

  @Data
  @Builder
  @AllArgsConstructor
  @NoArgsConstructor
  public static class Response {
    private Long id;
    private String name;
    private int price;
    private long stock;
  }
}
