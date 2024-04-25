package com.cdy.ecommerce.ecommerce.domain.order.business.repository;

import com.cdy.ecommerce.ecommerce.domain.order.business.model.ProductOrder;
import com.cdy.ecommerce.ecommerce.domain.order.infrastructure.IProductOrderJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class ProductOrderCoreRepository implements IProductOrderRepository{
    private final IProductOrderJpaRepository productOrderJpaRepository;

    @Override
    public ProductOrder save(ProductOrder productOrder) {
        return productOrderJpaRepository.save(productOrder);
    }


}
