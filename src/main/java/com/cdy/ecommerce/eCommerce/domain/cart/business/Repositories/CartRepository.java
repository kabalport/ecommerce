package com.cdy.ecommerce.eCommerce.domain.cart.business.Repositories;

import com.cdy.ecommerce.eCommerce.domain.cart.business.Models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long> {

  @Query("select cart from Cart cart where cart.owner.userId = :userId")
  public Optional<Cart> getCartOfMember(@Param("userId") String userId);
}
