package com.cdy.ecommerce.ecommerce.domain.order;

import com.cdy.ecommerce.ecommerce.domain.order.business.ProductOrder;
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
