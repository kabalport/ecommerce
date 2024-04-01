package com.cdy.ecommerce.api.product;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.cdy.ecommerce.domain.product.business.Product;
import com.cdy.ecommerce.domain.product.business.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
  @GetMapping("/read/{pno}")
  public Product readOne(@PathVariable(name = "pno") Long pno) {
    return productService.getOne(pno);
  }

  /**
   * 상품 등록 API
   * @param productDTO
   * @return
   */
  @PostMapping("/")
  public Map<String, Long> register(ProductDTO productDTO) {
    // 서비스 호출
    Long pno = productService.register(productDTO);
    return Map.of("result", pno);
  }


}