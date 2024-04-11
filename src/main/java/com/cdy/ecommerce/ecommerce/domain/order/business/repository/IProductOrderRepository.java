package com.cdy.ecommerce.ecommerce.domain.order.business.repository;

import com.cdy.ecommerce.ecommerce.api.v1.analysis.TrendController;
import com.cdy.ecommerce.ecommerce.domain.order.business.model.ProductOrder;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;

public interface IProductOrderRepository {

    ProductOrder save(ProductOrder productOrder);

    List<TrendController.TrendDTO> findTopSellingProducts(LocalDate startDate, LocalDate endDate, Pageable pageable);

}
