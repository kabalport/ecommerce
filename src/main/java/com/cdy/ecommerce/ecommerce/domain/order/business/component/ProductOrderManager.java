package com.cdy.ecommerce.ecommerce.domain.order.business.component;

import com.cdy.ecommerce.ecommerce.api.v1.analysis.TrendController;
import com.cdy.ecommerce.ecommerce.domain.order.business.model.ProductOrder;
import com.cdy.ecommerce.ecommerce.domain.order.business.repository.IProductOrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@AllArgsConstructor
public class ProductOrderManager {

    private final IProductOrderRepository productOrderRepository;

    public void saveOrder(ProductOrder order) {
        productOrderRepository.save(order);
    }



}
