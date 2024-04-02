package com.cdy.ecommerce.eCommerce.api.cart.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class CartItemListDTO {

  private Long cino;

  private int qty;

  private Long pno;

  private String pname;

  private int price;



  public CartItemListDTO(Long cino, int qty, Long pno, String pname, int price) {
    this.cino = cino;
    this.qty = qty;
    this.pno = pno;
    this.pname = pname;
    this.price = price;

  }
}
