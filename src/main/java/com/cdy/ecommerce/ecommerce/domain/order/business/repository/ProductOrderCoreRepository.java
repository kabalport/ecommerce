package com.cdy.ecommerce.ecommerce.domain.order.business.repository;

import com.cdy.ecommerce.ecommerce.api.v1.analysis.TrendController;
import com.cdy.ecommerce.ecommerce.domain.order.business.model.ProductOrder;
import com.cdy.ecommerce.ecommerce.domain.order.infrastructure.IProductOrderJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
@AllArgsConstructor
public class ProductOrderCoreRepository implements IProductOrderRepository{
    private final IProductOrderJpaRepository productOrderJpaRepository;

    @Override
    public ProductOrder save(ProductOrder productOrder) {
        return productOrderJpaRepository.save(productOrder);
    }

    @Override
    public List<TrendController.TrendDTO> findTopSellingProducts(LocalDate startDate, LocalDate endDate, Pageable pageable) {
        return productOrderJpaRepository.findTopSellingProducts(startDate, endDate, pageable);
    }
}
