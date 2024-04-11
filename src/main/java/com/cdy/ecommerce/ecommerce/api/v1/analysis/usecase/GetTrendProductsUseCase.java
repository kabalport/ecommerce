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
        return List.of();
    }
}
