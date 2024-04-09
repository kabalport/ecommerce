package com.cdy.ecommerce.ecommerce.api.order.controller;



import com.cdy.ecommerce.ecommerce.api.order.usecase.ProductOrderAndPayUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/api/order")
public class ProductOrderController {

    private final ProductOrderAndPayUseCase productOrderAndPayUseCase;

    /**
     * 주문하고결제하기 API
     * 상품 재고가 있으면 주문이 성공하면 결제를 합니다.
     */
//    @PostMapping
//    public ProductOrderDTO.Response order(@RequestBody ProductOrderDTO.Request request) {
//        // 사용자 식별자와 (상품 ID, 수량) 목록을 입력받아 주문하고 결제를 수행하는 API 를 작성합니다.
//        ProductOrder response = productOrderAndPayUseCase.execute(request);
//
//        return entityToDTO(response);
//    }
//
//
//    private ProductOrderDTO.Response entityToDTO(ProductOrder productOrder) {
//        // 변환
//        return ProductOrderDTO.Response.builder().build();
//    }
}
