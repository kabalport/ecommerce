package com.cdy.ecommerce.eCommerce.api.cart.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CartItemListDTO {

  private Long cartItemId;

  private int qty;

  private Long productIt;

  private String pname;

  private int price;

}
