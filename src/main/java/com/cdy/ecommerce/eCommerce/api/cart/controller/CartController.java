package com.cdy.ecommerce.eCommerce.api.cart.controller;

import com.cdy.ecommerce.eCommerce.api.cart.dto.CartItemDTO;
import com.cdy.ecommerce.eCommerce.api.cart.dto.CartItemListDTO;
import com.cdy.ecommerce.eCommerce.api.cart.CartService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;


// 사용자는 구매 이전에 관심 있는 상품들을 장바구니에 적재할 수 있습니다.
// 이 기능을 제공하기 위해 `장바구니에 상품 추가/삭제` API 와 `장바구니 조회` API 가 필요합니다.
// 위 두 기능을 제공하기 위해 어떤 요구사항의 비즈니스 로직을 설계해야할 지 고민해 봅니다.

@RestController
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/api/cart")
public class CartController {

  private final CartService cartService;


//장바구니에 상품 추가 API
//  @PreAuthorize("#itemDTO.email == authentication.name")
  @PostMapping("/change")
  public List<CartItemListDTO> changeCart(@RequestBody CartItemDTO itemDTO) {

    if (itemDTO.getQty() <= 0) {
      return cartService.remove(itemDTO.getCino());
    }
    return cartService.addOrModify(itemDTO);
  }

// `장바구니 조회` API 가 필요합니다.
//  @PreAuthorize("hasAnyRole('ROLE_USER')")
  @GetMapping("/items")
  public List<CartItemListDTO> getCartItems(Principal principal) {

    String userId = principal.getName();
    log.info("--------------------------------------------");
    log.info("userId: " + userId);

    return cartService.getCartItems(userId);
  }

//`장바구니에 상품 삭제` API
//  @PreAuthorize("hasAnyRole('ROLE_USER')")
  @DeleteMapping("/{cino}")
  public List<CartItemListDTO> removeFromCart(@PathVariable("cino") Long cino) {

    log.info("cart item no: " + cino);

    return cartService.remove(cino);
  }
}
