package com.cdy.ecommerce.ecommerce.domain.product.infrastructure;

import com.cdy.ecommerce.ecommerce.domain.product.business.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductJpaRepository extends JpaRepository<Product, Long> {}