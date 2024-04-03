package com.cdy.ecommerce.eCommerce.domain.cart.business.Models;

import com.cdy.ecommerce.eCommerce.domain.product.business.Models.Product;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@ToString(exclude = "cart")
@Table(
    name = "ecommerce_item",
    indexes = {
      @Index(columnList = "cart_cno", name = "idx_cartitem_cart"),
      @Index(columnList = "product_id, cart_cno", name = "idx_cartitem_pno_cart")
    })
public class CartItem {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long cino;

  @ManyToOne
  @JoinColumn(name = "product_id")
  private Product product;

  @ManyToOne
  @JoinColumn(name = "cart_cno")
  private Cart cart;

  private int qty;

  public void changeQty(int qty) {
    this.qty = qty;
  }
}
