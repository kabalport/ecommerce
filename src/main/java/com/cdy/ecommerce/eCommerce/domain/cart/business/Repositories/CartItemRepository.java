package com.cdy.ecommerce.eCommerce.domain.cart.business.Repositories;

import com.cdy.ecommerce.eCommerce.api.cart.dto.CartItemListDTO;
import com.cdy.ecommerce.eCommerce.domain.cart.business.Models.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

  @Query(
      "select "
          + " new com.cdy.ecommerce.eCommerce.api.cart.dto.CartItemListDTO(ci.cino,  ci.qty,  p.id, p.pname, p.price )  "
          + " from "
          + "   CartItem ci inner join Cart mc on ci.cart = mc "
          + "   left join Product p on ci.product = p "
          + " where "
          + "   mc.owner.userId = :userId"
          + " order by ci desc ")
  public List<CartItemListDTO> getItemsOfCartDTOByUserId(@Param("userId") String userId);

  @Query(
      "select"
          + " ci "
          + " from "
          + "   CartItem ci inner join Cart c on ci.cart = c "
          + " where "
          + "   c.owner.userId = :userId and ci.product.id = :id")
  public CartItem getItemOfPno(@Param("userId") String userId, @Param("id") Long id);

  @Query(
      "select "
          + "  c.cno "
          + "from "
          + "  Cart c inner join CartItem ci on ci.cart = c "
          + " where "
          + "  ci.cino = :cino")
  public Long getCartFromItem(@Param("cino") Long cino);

  @Query(
      "select new com.cdy.ecommerce.eCommerce.api.cart.dto.CartItemListDTO(ci.cino,  ci.qty,  p.id, p.pname, p.price )  "
          + " from "
          + "   CartItem ci inner join Cart mc on ci.cart = mc "
          + "   left join Product p on ci.product = p "
          + " where "
          + "  mc.cno = :cno"
          + " order by ci desc ")
  public List<CartItemListDTO> getItemsOfCartDTOByCart(@Param("cno") Long cno);
}
