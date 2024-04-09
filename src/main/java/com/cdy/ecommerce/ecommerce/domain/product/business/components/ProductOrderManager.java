package com.cdy.ecommerce.ecommerce.domain.product.business.components;

import com.cdy.ecommerce.ecommerce.domain.product.business.repositories.IProductOrderRepository;
import com.cdy.ecommerce.ecommerce.domain.product.business.models.ProductOrder;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ProductOrderManager {

    private final IProductOrderRepository productOrderRepository;

    public void saveOrder(ProductOrder order) {
        productOrderRepository.save(order);
    }
}
