package com.cdy.ecommerce.eCommerce.api.product.controller;


import com.cdy.ecommerce.eCommerce.api.product.dto.ProductDTO;
import com.cdy.ecommerce.eCommerce.api.product.usecase.GetProductUseCase;
import com.cdy.ecommerce.eCommerce.api.product.usecase.RegisterProductUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/api/products")
public class ProductController {
  private final GetProductUseCase getProductUseCase;
  private final RegisterProductUseCase registerProductUseCase;
  /**
   * 상품 조회 API
   * 상품 정보 ( ID, 이름, 가격, 잔여수량 ) 을 조회하는 API 를 작성합니다.
   * 조회시점의 상품별 잔여수량이 정확하면 좋습니다.
   *
   * @param pno
   * @return
   */
  @GetMapping("/{pno}")
  public ProductDTO getOne(@PathVariable(name = "pno") Long pno) {
    return getProductUseCase.execute(pno);
  }

  /**
   * 상품 등록 API
   * @param productDTO
   * @return
   */
  @PostMapping
  public Map<String, Long> register(@RequestBody ProductDTO productDTO, Long memberId) {
    // 서비스 호출
    Long pno = registerProductUseCase.execute(productDTO,memberId);
    return Map.of("result", pno);
  }

}