package com.cdy.ecommerce.eCommerce.domain.product.business.Repositories;

import com.cdy.ecommerce.eCommerce.domain.product.business.Models.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {
}
