package com.cdy.ecommerce.ecommerce.domain.product.infrastructure;

import com.cdy.ecommerce.ecommerce.domain.product.business.models.ProductStock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductStockJpaRepository  extends JpaRepository<ProductStock, Long> {}
