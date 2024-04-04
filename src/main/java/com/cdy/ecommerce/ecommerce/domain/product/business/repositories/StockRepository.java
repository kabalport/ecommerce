package com.cdy.ecommerce.ecommerce.domain.product.business.repositories;

import com.cdy.ecommerce.ecommerce.domain.product.business.models.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {
}
