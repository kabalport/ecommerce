package com.cdy.ecommerce.ecommerce.domain.product.api;

import lombok.*;

import java.math.BigDecimal;

@Data
public class ProductDTO {

  @Data
  @Builder
  @AllArgsConstructor
  @NoArgsConstructor
  public static class Request {

    private String userId;
    private String name;
    private BigDecimal price;
    private int stock;
  }

  @Data
  @Builder
  @AllArgsConstructor
  @NoArgsConstructor
  public static class Response {
    private Long id;
    private String name;
    private BigDecimal price;
    private long stock;
  }
}
