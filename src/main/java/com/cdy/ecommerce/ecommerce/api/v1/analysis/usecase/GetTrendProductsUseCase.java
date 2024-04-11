package com.cdy.ecommerce.ecommerce.api.v1.analysis.usecase;

import com.cdy.ecommerce.ecommerce.api.v1.analysis.TrendController.TrendDTO;
import com.cdy.ecommerce.ecommerce.domain.order.business.component.ProductOrderManager;
import com.cdy.ecommerce.ecommerce.domain.product.business.component.ProductReader;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class GetTrendProductsUseCase {
    private final ProductOrderManager productOrderManager;
    private final ProductReader productReader;

    public List<TrendDTO> execute() {
        LocalDate oneWeekAgo = LocalDate.now().minusWeeks(1);
        LocalDate today = LocalDate.now();

        // 상위 5개 상품을 조회하기 위한 Pageable 객체 생성
        Pageable topFive = PageRequest.of(0, 5);

        // 상품 조회
        List<TrendDTO> topSellingProducts = productOrderManager.findTopSellingProducts(oneWeekAgo, today, topFive);

        return topSellingProducts;
    }
}
