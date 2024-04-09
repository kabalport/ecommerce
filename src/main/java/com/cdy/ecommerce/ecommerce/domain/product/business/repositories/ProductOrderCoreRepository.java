package com.cdy.ecommerce.ecommerce.domain.product.business.repositories;

import com.cdy.ecommerce.ecommerce.domain.product.business.models.ProductOrder;
import com.cdy.ecommerce.ecommerce.domain.product.infrastructure.IProductOrderJpaRepository;
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
