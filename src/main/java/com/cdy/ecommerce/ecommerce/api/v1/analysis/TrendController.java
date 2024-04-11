package com.cdy.ecommerce.ecommerce.api.v1.analysis;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/trend")
public class TrendController {
    /**
     * 인기 상품조회
     * 일주일간 제일 잘 팔린 인기상품 5개를 보여줍니다.
     * 
     * 주문수량 Top5 조회
     * 기간은 일주일
     */
    @GetMapping("/products")
    public TrendDTO getTrendProducts(){

        return null;
    }

    private class TrendDTO {
    }
}
