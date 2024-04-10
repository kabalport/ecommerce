package com.cdy.ecommerce.ecommerce.domain.cart.business.model;

import com.cdy.ecommerce.ecommerce.domain.product.business.model.Product;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@ToString(exclude = "cart")
@Table(
    name = "ecommerce_cart_item",
    indexes = {
      @Index(columnList = "cart_id", name = "idx_cartitem_cart"),
      @Index(columnList = "product_id, cart_id", name = "idx_cartitem_pno_cart")
    })
public class CartItem {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ecommerce_cart_item_id")
  private Long id;

  @ManyToOne
  @JoinColumn(name = "product_id")
  private Product product;

  @ManyToOne
  @JoinColumn(name = "cart_id")
  private Cart cart;
  @Column(name = "cart_quantity")
  private int quantity;

  public void changeQty(int qty) {
    this.quantity = qty;
  }
}
