package com.cdy.ecommerce.ecommerce.domain.order.business.component;

import com.cdy.ecommerce.ecommerce.domain.order.business.model.ProductOrder;
import com.cdy.ecommerce.ecommerce.domain.order.business.repository.IProductOrderRepository;
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
