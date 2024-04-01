package com.cdy.ecommerce.eCommerce.api.product.dto;

import lombok.*;

@Data
public class ProductDTO {

  @Data
  @Builder
  @AllArgsConstructor
  @NoArgsConstructor
  public static class Request {
    private String pname;
    private int price;
    private int stock;
  }

  @Data
  @Builder
  @AllArgsConstructor
  @NoArgsConstructor
  public static class Response {
    private Long id;
    private String pname;
    private int price;
    private int stock;
  }
}
