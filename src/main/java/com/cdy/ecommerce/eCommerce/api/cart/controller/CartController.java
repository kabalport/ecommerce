package com.cdy.ecommerce.eCommerce.api.cart.controller;

import com.cdy.ecommerce.eCommerce.api.cart.dto.CartItemDTO;
import com.cdy.ecommerce.eCommerce.api.cart.dto.CartItemListDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

// 사용자는 구매 이전에 관심 있는 상품들을 장바구니에 적재할 수 있습니다.
@RestController
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/api/cart")
public class CartController {

// 장바구니에 상품 수정 API
  @PostMapping("/change")
  public List<CartItemListDTO> changeCart(@RequestBody CartItemDTO itemDTO) {

    return null;
  }

// 장바구니 조회 API
  @GetMapping("/items")
  public List<CartItemListDTO> getCartItems(Principal principal) {
    return null;
  }

// 장바구니에 상품 삭제 API
  @DeleteMapping("/{cino}")
  public List<CartItemListDTO> removeFromCart(@PathVariable("cino") Long cino) {
    return null;
  }
}
