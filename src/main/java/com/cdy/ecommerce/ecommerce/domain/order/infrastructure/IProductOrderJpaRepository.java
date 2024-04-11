package com.cdy.ecommerce.ecommerce.domain.order.infrastructure;

import com.cdy.ecommerce.ecommerce.api.v1.analysis.TrendController;
import com.cdy.ecommerce.ecommerce.domain.order.business.model.ProductOrder;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface IProductOrderJpaRepository extends JpaRepository<ProductOrder, Long> {


    List<TrendController.TrendDTO> findTopSellingProducts(LocalDate startDate, LocalDate endDate, Pageable pageable);

}
