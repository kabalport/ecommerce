package com.cdy.ecommerce.eCommerce.api.cart.dto;

import lombok.Data;

@Data
public class CartItemDTO {

  private String userId;

  private Long productId;

  private int qty;

  private Long cartItemId;
}
