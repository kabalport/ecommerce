package com.cdy.ecommerce.ecommerce.api.order.controller;

// 주문하기
// 사용자 식별자와 (상품 ID, 수량) 목록을 입력받아 주문하고 결제를 수행하는 API 를 작성합니다.

// 결제는 기 충전된 잔액을 기반으로 수행하며 성공할 시 잔액을 차감해야 합니다.
// 데이터 분석을 위해 결제 성공 시에 실시간으로 주문 정보를 데이터 플랫폼에 전송해야 합니다.

// 사용자 식별자와 (상품 ID, 수량) 목록을 기반으로 결제 처리
// 1. 사용자 잔액 확인 및 차감
// 2. Payment 엔티티 생성 및 저장
// 3. 결제 상태에 따른 로직 처리
// 4. 결제 성공 시, 데이터 플랫폼으로 주문 정보 전송

import com.cdy.ecommerce.ecommerce.api.order.dto.OrderDTO;
import com.cdy.ecommerce.ecommerce.api.order.usecase.OrderAndPayUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/api/order")
public class OrderController {

    private final OrderAndPayUseCase orderAndPayUseCase;

    /**
     * 주문 등록 API
     * 상품 재고가 있으면 주문이 성공하면 결제를 합니다.
     */
    @PostMapping
    public Map<String, Long> register(@RequestBody OrderDTO.Request orderRequest, Long memberId) {
        // 주문을 하고 결제를 수행한다.
        Long orderResponse = orderAndPayUseCase.execute(orderRequest,memberId);
        return Map.of("result", orderResponse);
    }

}
