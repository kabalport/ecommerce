package com.cdy.ecommerce.eCommerce.api.product;

import java.util.Map;

import com.cdy.ecommerce.eCommerce.domain.product.Models.Product;
import com.cdy.ecommerce.eCommerce.domain.product.business.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/api/products")
public class ProductController {

  private final ProductService productService; // ProductServcie 주입

  /**
   * 상품 조회 API
   * 상품 정보 ( ID, 이름, 가격, 잔여수량 ) 을 조회하는 API 를 작성합니다.
   * 조회시점의 상품별 잔여수량이 정확하면 좋습니다.
   *
   * @param pno
   * @return
   */
  @GetMapping("/{pno}")
  public Product getOne(@PathVariable(name = "pno") Long pno) {
    return productService.getOne(pno);
  }

  /**
   * 상품 등록 API
   * @param productDTO
   * @return
   */
  @PostMapping("/")
  public Map<String, Long> register(ProductDTO productDTO,Long memberId) {
    // 서비스 호출
    Long pno = productService.register(productDTO,memberId);
    return Map.of("result", pno);
  }


}