package com.cdy.ecommerce.ecommerce.admin.v1.analysis.usecase;

import com.cdy.ecommerce.ecommerce.admin.v1.analysis.TrendController.TrendDTO;
import com.cdy.ecommerce.ecommerce.domain.order.business.component.ProductOrderManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class GetTrendProductsUseCase {
    private final ProductOrderManager productOrderManager;

    public List<TrendDTO> execute() {
        return List.of();
    }
}
