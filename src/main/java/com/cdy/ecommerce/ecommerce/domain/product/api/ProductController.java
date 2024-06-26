package com.cdy.ecommerce.ecommerce.domain.product.api;


import com.cdy.ecommerce.ecommerce.domain.product.api.ProductDTO;
import com.cdy.ecommerce.ecommerce.domain.product.business.ProductService;
import com.cdy.ecommerce.ecommerce.domain.product.business.model.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/api/products")
public class ProductController {
  private final ProductService productService;

  /**
   * 상품 조회 API
   * 상품 정보 ( ID, 이름, 가격, 잔여수량 ) 을 조회하는 API 를 작성합니다.
   * 조회시점의 상품별 잔여수량이 정확하면 좋습니다.
   * @param productId
   * @return
   */
  @GetMapping("/{productId}")
  public ProductDTO.Response getOne(@PathVariable(name = "productId") Long productId) {
    return entityToDTO(productService.getProduct(productId));
  }


  private ProductDTO.Response entityToDTO(Product product) {
    // 변환
    return ProductDTO.Response.builder().id(product.getId()).name(product.getName()).price(product.getPrice()).stock(product.getProductStock().getQuantity()).build();
  }

}