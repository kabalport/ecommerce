package com.cdy.ecommerce.eCommerce.domain.cart.business.Models;

import com.cdy.ecommerce.eCommerce.domain.member.business.Models.Member;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = "owner")
@Table(
    name = "ecommerce_cart",
    indexes = {@Index(name = "idx_cart_userId", columnList = "member_owner")})
public class Cart {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long cno;

  @OneToOne
  @JoinColumn(name = "member_owner")
  private Member owner;
}
