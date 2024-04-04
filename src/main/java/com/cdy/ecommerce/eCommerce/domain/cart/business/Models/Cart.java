package com.cdy.ecommerce.eCommerce.domain.cart.business.Models;

import com.cdy.ecommerce.eCommerce.domain.member.business.Models.Member;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "ecommerce_cart")
public class Cart {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ecommerce_cart_id")
  private Long id;

  @Column(name = "member_id")
  private Long memberId;
}
