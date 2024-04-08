package com.cdy.ecommerce.ecommerce.api.product.controller;


import com.cdy.ecommerce.ecommerce.api.product.dto.ProductDTO;
import com.cdy.ecommerce.ecommerce.api.product.usecase.GetProductUseCase;
import com.cdy.ecommerce.ecommerce.api.product.usecase.RegisterProductUseCase;
import com.cdy.ecommerce.ecommerce.domain.product.business.models.Product;
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
   * @param id
   * @return
   */
  @GetMapping("/{id}")
  public ProductDTO.Response getOne(@PathVariable(name = "id") Long id) {
    return entityToDTO(getProductUseCase.execute(id));
  }

  /**
   * 상품 등록 API
   */
  @PostMapping
  public ProductDTO.Response register(@RequestBody ProductDTO.Request request) {
    // 서비스 호출
    Product response = registerProductUseCase.execute(request);
    return entityToDTO(response);
  }

  private ProductDTO.Response entityToDTO(Product product) {
    // 변환
    return ProductDTO.Response.builder().id(product.getId()).pname(product.getName()).price(product.getPrice()).build();
  }

}